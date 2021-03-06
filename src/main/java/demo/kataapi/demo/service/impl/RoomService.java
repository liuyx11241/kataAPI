package demo.kataapi.demo.service.impl;

import demo.kataapi.demo.domain.Room;
import demo.kataapi.demo.repo.RoomRepo;
import demo.kataapi.demo.service.IRoomService;
import demo.kataapi.demo.service.dto.RoomDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService {

    @Autowired
    RoomRepo roomRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<RoomDto> listRooms() {
        List<Room> listRoom = roomRepo.findAll(Sort.by("capacity"));
        return listRoom.stream().map(room -> modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoom(String idRoom) {
        return modelMapper.map(findOrThrow(idRoom), RoomDto.class);
    }

    Room findOrThrow(String idRoom) {
        if (Objects.isNull(idRoom)) {
            throw new IllegalArgumentException("Room id cannot be null");
        }
        return roomRepo.findById(idRoom)
            .orElseThrow(() -> new IllegalArgumentException(String.format("Room %s does not exist", idRoom)));
    }
}