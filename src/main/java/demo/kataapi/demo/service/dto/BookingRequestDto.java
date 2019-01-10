package demo.kataapi.demo.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import demo.kataapi.demo.service.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(description = "Request Body for creating")
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

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The date in format yyyyMMdd", required = true)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = DateUtil.reformDate(date);
    }

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The begin time in hour", required = true)
    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    @ApiModelProperty(notes = "The end time in hour", required = true)
    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    @ApiModelProperty(notes = "The person's name who will book", required = true)
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @ApiModelProperty(notes = "The id of room to book", required = true)
    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }
}
