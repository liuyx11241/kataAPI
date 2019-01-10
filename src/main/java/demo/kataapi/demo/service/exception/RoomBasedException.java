package demo.kataapi.demo.service.exception;

public class RoomBasedException extends Exception {

    private String idRoom;

    public RoomBasedException(String idRoom) {
        this.idRoom = idRoom;
    }

    public RoomBasedException(String idRoom, String message) {
        super(message);
        this.idRoom = idRoom;
    }

    public RoomBasedException(String idRoom, String message, Throwable cause) {
        super(message, cause);
        this.idRoom = idRoom;
    }

    public RoomBasedException(String idRoom, Throwable cause) {
        super(cause);
        this.idRoom = idRoom;
    }

    public RoomBasedException(String idRoom, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.idRoom = idRoom;
    }

    public String getIdRoom() {
        return idRoom;
    }
}
