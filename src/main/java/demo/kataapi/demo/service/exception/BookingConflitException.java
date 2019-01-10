package demo.kataapi.demo.service.exception;

import demo.kataapi.demo.service.dto.BookingAvailabelDto;

public class BookingConflitException extends Exception {

    private BookingAvailabelDto bookingAvailabelDto;

    public BookingConflitException(BookingAvailabelDto bookingAvailabelDto) {
        this.bookingAvailabelDto = bookingAvailabelDto;
    }

    public BookingConflitException(String message, BookingAvailabelDto bookingAvailabelDto) {
        super(message);
        this.bookingAvailabelDto = bookingAvailabelDto;
    }

    public BookingConflitException(String message, Throwable cause, BookingAvailabelDto bookingAvailabelDto) {
        super(message, cause);
        this.bookingAvailabelDto = bookingAvailabelDto;
    }

    public BookingAvailabelDto getBookingAvailabelDto() {
        return bookingAvailabelDto;
    }
}
