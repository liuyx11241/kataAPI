package demo.kataapi.demo.mvc.rest;

import demo.kataapi.demo.service.IRoomService;
import demo.kataapi.demo.service.dto.RoomDto;
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

    @GetMapping
    public List<RoomDto> getListRoom() {
        return roomService.listRooms();
    }

    @GetMapping("/{id}")
    public RoomDto getRoom(@PathVariable("id") @NotNull String idRoom) {
        return roomService.getRoom(idRoom);
    }
}
