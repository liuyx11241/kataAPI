package demo.kataapi.demo.service.exception;

public class BookingConflitRuntimeException extends RoomBasedRuntimeException {
    public BookingConflitRuntimeException(String idRoom) {
        super(idRoom);
    }

    public BookingConflitRuntimeException(String idRoom, String message) {
        super(idRoom, message);
    }

    public BookingConflitRuntimeException(String idRoom, String message, Throwable cause) {
        super(idRoom, message, cause);
    }

    public BookingConflitRuntimeException(String idRoom, Throwable cause) {
        super(idRoom, cause);
    }

    public BookingConflitRuntimeException(String idRoom, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(idRoom, message, cause, enableSuppression, writableStackTrace);
    }
}
