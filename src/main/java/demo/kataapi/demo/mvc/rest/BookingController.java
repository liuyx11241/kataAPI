package demo.kataapi.demo.mvc.rest;

import demo.kataapi.demo.service.IBookingService;
import demo.kataapi.demo.service.dto.BookingDto;
import demo.kataapi.demo.service.dto.BookingRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/${demo.kata.api.version}/bookings")
public class BookingController {

    @Autowired
    IBookingService bookingService;

    @GetMapping
    public Page<BookingDto> getListBookings(
        @RequestParam(value = "pageIndex", required = false, defaultValue = "0") Integer pageIndex,
        @RequestParam(value = "pageSize", required = false, defaultValue = "50") Integer pageSize) {
        return new PageImpl<>(bookingService.listBookings(pageIndex, pageSize));
    }

    @GetMapping("/{idBooking}")
    public BookingDto getBooking(@PathVariable String idBooking) {
        return bookingService.findBooking(idBooking);
    }

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingRequestDto bookingRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(bookingRequest));
    }

    @DeleteMapping("/{idBooking}")
    public ResponseEntity<BookingDto> deleteBooking(@PathVariable String idBooking) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookingService.deleteBooking(idBooking));
    }
}