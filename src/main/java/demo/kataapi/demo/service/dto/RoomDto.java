package demo.kataapi.demo.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Information of Room")
public class RoomDto {
    @ApiModelProperty(value = "id room")
    private String idTech;

    @ApiModelProperty(value = "name room")
    private String name;

    @ApiModelProperty(value = "accepted number of persons ")
    private Integer capacity;

    public String getIdTech() {
        return idTech;
    }

    public void setIdTech(String idTech) {
        this.idTech = idTech;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
