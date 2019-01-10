package demo.kataapi.demo.repo;

import demo.kataapi.demo.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, String> {
}
