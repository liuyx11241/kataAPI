package demo.kataapi.demo.service;

import demo.kataapi.demo.service.dto.RoomDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceTest {

    @Autowired
    IRoomService roomService;

    @Test
    public void listRooms() {
        List<RoomDto> listRoom = roomService.listRooms();
        Assert.assertNotNull(listRoom);
        Assert.assertEquals(10, listRoom.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getRoom_invalid() {
        RoomDto room = roomService.getRoom(null);
        Assert.assertNull(room);
    }

    @Test
    public void getRoom_valid() {
        RoomDto room = roomService.getRoom("0");
        Assert.assertNotNull(room);
        Assert.assertEquals("0", room.getIdTech());
    }
}