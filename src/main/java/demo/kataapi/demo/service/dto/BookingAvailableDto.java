package demo.kataapi.demo.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.SortedSet;

@ApiModel(description = "list of available time for booking a room")
public class BookingAvailableDto {

    @ApiModelProperty("id room")
    private String idRoom;

    @ApiModelProperty("date to book")
    private String date;

    @ApiModelProperty("available time")
    private SortedSet<Integer> availableTime;

    public BookingAvailableDto(String idRoom, String date, SortedSet<Integer> availableTime) {
        this.idRoom = idRoom;
        this.date = date;
        this.availableTime = availableTime;
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

    public SortedSet<Integer> getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(SortedSet<Integer> availableTime) {
        this.availableTime = availableTime;
    }
}
