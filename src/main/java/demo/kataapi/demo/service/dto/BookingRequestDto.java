package demo.kataapi.demo.service.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BookingRequestDto {

    @NotNull
    private String date;

    @NotNull
    @Min(0)
    @Max(23)
    private Integer startTime;

    @NotNull
    @Min(0)
    @Max(23)
    private Integer endTime;

    @NotNull
    private String personName;

    @NotNull
    private String idRoom;
}
