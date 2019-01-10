package demo.kataapi.demo.mvc.rest;

import demo.kataapi.demo.service.IRoomService;
import demo.kataapi.demo.service.dto.RoomDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/${demo.kata.api.version}/rooms")
public class RoomController {

    @Autowired
    IRoomService roomService;

    @ApiOperation(value = "getListRoom")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = RoomDto.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @GetMapping
    public List<RoomDto> getListRoom() {
        return roomService.listRooms();
    }

    @ApiOperation(value = "getListRoom")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = RoomDto.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public RoomDto getRoom(@PathVariable("id") @NotNull String idRoom) {
        return roomService.getRoom(idRoom);
    }
}