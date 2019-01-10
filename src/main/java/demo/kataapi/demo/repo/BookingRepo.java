package demo.kataapi.demo.repo;

import demo.kataapi.demo.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, String> {
    List<Booking> findAllByRoom_IdTechAndDate(String idRoom, String date);
}
