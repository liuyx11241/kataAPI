package demo.kataapi.demo.service;

import demo.kataapi.demo.domain.Room;
import demo.kataapi.demo.service.dto.RoomDto;

import java.util.List;

public interface IRoomService {

    List<RoomDto> listRooms();

    RoomDto getRoom(String idRoom);
}
