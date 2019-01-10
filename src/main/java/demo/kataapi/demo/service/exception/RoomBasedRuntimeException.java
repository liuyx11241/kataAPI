package demo.kataapi.demo.service.exception;

public abstract class RoomBasedRuntimeException extends Exception {

    private String idRoom;

    public RoomBasedRuntimeException(String idRoom) {
        this.idRoom = idRoom;
    }

    public RoomBasedRuntimeException(String idRoom, String message) {
        super(message);
        this.idRoom = idRoom;
    }

    public RoomBasedRuntimeException(String idRoom, String message, Throwable cause) {
        super(message, cause);
        this.idRoom = idRoom;
    }

    public RoomBasedRuntimeException(String idRoom, Throwable cause) {
        super(cause);
        this.idRoom = idRoom;
    }

    public RoomBasedRuntimeException(String idRoom, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.idRoom = idRoom;
    }

    public String getIdRoom() {
        return idRoom;
    }
}
