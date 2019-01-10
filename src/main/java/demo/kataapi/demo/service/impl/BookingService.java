package demo.kataapi.demo.service.impl;

import demo.kataapi.demo.domain.Booking;
import demo.kataapi.demo.domain.Room;
import demo.kataapi.demo.repo.BookingRepo;
import demo.kataapi.demo.repo.RoomRepo;
import demo.kataapi.demo.service.IBookingService;
import demo.kataapi.demo.service.dto.BookingAvailabelDto;
import demo.kataapi.demo.service.dto.BookingDto;
import demo.kataapi.demo.service.dto.BookingRequestDto;
import demo.kataapi.demo.service.exception.BookingConflitException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingService implements IBookingService {
    @Autowired
    RoomRepo roomRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ModelMapper modelMapper;

    private Set<Integer> availableTime;

    public BookingService() {
        availableTime = new TreeSet<Integer>();
        for (int i = 0; i < 24; i++) {
            availableTime.add(i);
        }
        availableTime = Collections.unmodifiableSet(availableTime);
    }

    @Override
    public List<BookingDto> listBookings(int pageIndex, int pageSize) {
        return bookingRepo.findAll(PageRequest.of(pageIndex, pageSize))
            .stream()
            .map(booking -> modelMapper.map(booking, BookingDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public BookingDto findBooking(String idBooking) {
        return modelMapper.map(findBookingOrThrow(idBooking), BookingDto.class);
    }

    @Override
    public BookingDto deleteBooking(String idBooking) {
        Booking booking = findBookingOrThrow(idBooking);
        bookingRepo.delete(booking);
        return modelMapper.map(booking, BookingDto.class);
    }

    @Override
    public BookingDto createBooking(BookingRequestDto bookingRequestDto) throws BookingConflitException {
        if (Objects.isNull(bookingRequestDto) || Objects.isNull(bookingRequestDto.getIdRoom())) {
            throw new IllegalArgumentException("Room id cannot be null");
        }
        Room bookingRoom = roomRepo.findById(bookingRequestDto.getIdRoom())
            .orElseThrow(() -> new IllegalArgumentException(
                String.format("Room %s doesn't exist", bookingRequestDto.getIdRoom())));
        SortedSet<Integer> availableBookings = new TreeSet<>(availableTime);
        List<Booking> listBookings = bookingRepo.findAllByRoom_IdTechAndDate(
            bookingRequestDto.getIdRoom(), bookingRequestDto.getDate());
        for (Booking booking : listBookings) {
            for (int time = booking.getStartTime(); time < booking.getEndTime(); time++) {
                availableBookings.remove(time);
            }
        }

        for (int time = bookingRequestDto.getStartTime(); time < bookingRequestDto.getEndTime(); time++) {
            if (!availableBookings.contains(time)) {
                throw new BookingConflitException(
                    new BookingAvailabelDto(bookingRequestDto.getIdRoom(), bookingRequestDto.getDate(), availableBookings));
            }
        }

        Booking booking = modelMapper.map(bookingRequestDto, Booking.class);
        booking.setRoom(bookingRoom);
        bookingRepo.save(booking);
        return modelMapper.map(booking, BookingDto.class);
    }

    private Booking findBookingOrThrow(String idBooking) {
        if (Objects.isNull(idBooking)) {
            throw new IllegalArgumentException("Id Booking cannot be null");
        }
        return bookingRepo.findById(idBooking)
            .orElseThrow(() -> new IllegalArgumentException(String.format("Booking %s does not existed", idBooking)));
    }
}
