package demo.kataapi.demo.service.exception;

import demo.kataapi.demo.service.dto.BookingAvailableDto;

public class BookingConflitException extends Exception {

    private BookingAvailableDto bookingAvailableDto;

    public BookingConflitException(BookingAvailableDto bookingAvailableDto) {
        this.bookingAvailableDto = bookingAvailableDto;
    }

    public BookingConflitException(String message, BookingAvailableDto bookingAvailableDto) {
        super(message);
        this.bookingAvailableDto = bookingAvailableDto;
    }

    public BookingConflitException(String message, Throwable cause, BookingAvailableDto bookingAvailableDto) {
        super(message, cause);
        this.bookingAvailableDto = bookingAvailableDto;
    }

    public BookingAvailableDto getBookingAvailableDto() {
        return bookingAvailableDto;
    }
}
