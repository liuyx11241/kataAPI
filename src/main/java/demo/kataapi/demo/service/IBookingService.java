package demo.kataapi.demo.service;

import demo.kataapi.demo.service.dto.BookingDto;
import demo.kataapi.demo.service.dto.BookingRequestDto;

import java.util.List;
import java.util.SortedSet;

public interface IBookingService {

    List<BookingDto> listBookings(int pageIndex, int pageSize);

    BookingDto findBooking(String idBooking);

    BookingDto deleteBooking(String idBooking);

    BookingDto createBooking(BookingRequestDto bookingRequestDto);

    SortedSet<Integer> listAvailableBookings(String idRoom, String date);
}
