package demo.kataapi.demo.repo;

import demo.kataapi.demo.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepo extends JpaRepository<Room, String> {
}
