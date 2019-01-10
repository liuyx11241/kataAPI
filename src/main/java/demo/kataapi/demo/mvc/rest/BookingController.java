package demo.kataapi.demo.mvc.rest;

import demo.kataapi.demo.service.dto.BookingDto;
import demo.kataapi.demo.service.dto.BookingRequestDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/${demo.kata.api.version}/bookings")
public class BookingController {

    @PostMapping("/{idRoom}")
    public BookingDto createBooking(@PathVariable String idRoom, @Valid @RequestBody BookingRequestDto bookingRequest) {
        return null;
    }

    @DeleteMapping("/{idRoom}")
    public BookingDto deleteBooking(@PathVariable String idRoom, @Valid @RequestBody BookingRequestDto bookingRequest) {
        return null;
    }
}