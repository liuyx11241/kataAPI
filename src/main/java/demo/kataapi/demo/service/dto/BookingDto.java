package demo.kataapi.demo.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "response of booking")
public class BookingDto {
    @ApiModelProperty("id booking")
    private String idTech;

    @ApiModelProperty
    private String date;

    @ApiModelProperty
    private Integer startTime;

    @ApiModelProperty
    private Integer endTime;

    @ApiModelProperty("person who booked this room")
    private String personName;

    private RoomDto room;

    public String getIdTech() {
        return idTech;
    }

    public void setIdTech(String idTech) {
        this.idTech = idTech;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }
}
