package demo.kataapi.demo.service.dto;

import java.util.SortedSet;

public class BookingAvailabelDto {

    private String idRoom;

    private String date;

    private SortedSet<Integer> availabelTime;

    public BookingAvailabelDto(String idRoom, String date, SortedSet<Integer> availabelTime) {
        this.idRoom = idRoom;
        this.date = date;
        this.availabelTime = availabelTime;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SortedSet<Integer> getAvailabelTime() {
        return availabelTime;
    }

    public void setAvailabelTime(SortedSet<Integer> availabelTime) {
        this.availabelTime = availabelTime;
    }
}
