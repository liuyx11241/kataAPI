package demo.kataapi.demo.service;

import demo.kataapi.demo.service.dto.BookingDto;
import demo.kataapi.demo.service.dto.BookingRequestDto;
import demo.kataapi.demo.service.exception.BookingConflitException;

import java.util.List;

public interface IBookingService {

    List<BookingDto> listBookings(int pageIndex, int pageSize);

    BookingDto findBooking(String idBooking);

    BookingDto deleteBooking(String idBooking);

    BookingDto createBooking(BookingRequestDto bookingRequestDto) throws BookingConflitException;
}
