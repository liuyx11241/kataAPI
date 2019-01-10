package demo.kataapi.demo.service.dto;

import demo.kataapi.demo.service.DateUtil;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookingRequestDto {

    @NotBlank
    private String date;

    @NotNull
    @Min(0)
    @Max(23)
    private Integer startTime;

    @NotNull
    @Min(0)
    @Max(23)
    private Integer endTime;

    @NotBlank
    private String personName;

    @NotBlank
    private String idRoom;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = DateUtil.reformDate(date);
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

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }
}
