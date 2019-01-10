package demo.kataapi.demo.mvc.rest;

import demo.kataapi.demo.service.IBookingService;
import demo.kataapi.demo.service.dto.BookingAvailabelDto;
import demo.kataapi.demo.service.dto.BookingDto;
import demo.kataapi.demo.service.dto.BookingRequestDto;
import demo.kataapi.demo.service.dto.RoomDto;
import demo.kataapi.demo.service.exception.BookingConflitException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "getListBookings")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = RoomDto.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @GetMapping
    public Page<BookingDto> getListBookings(
        @RequestParam(value = "pageIndex", required = false, defaultValue = "0") Integer pageIndex,
        @RequestParam(value = "pageSize", required = false, defaultValue = "50") Integer pageSize) {
        return new PageImpl<>(bookingService.listBookings(pageIndex, pageSize));
    }

    @ApiOperation(value = "getBooking")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = RoomDto.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{idBooking}")
    public BookingDto getBooking(@PathVariable String idBooking) {
        return bookingService.findBooking(idBooking);
    }

    @ApiOperation(value = "createBooking")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created", response = BookingDto.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 409, message = "Conflit", response = BookingAvailabelDto.class),
        @ApiResponse(code = 500, message = "Failure")})
    @PostMapping
    public ResponseEntity<Object> createBooking(@Valid @RequestBody BookingRequestDto bookingRequest) {
        BookingDto booking = null;
        try {
            booking = bookingService.createBooking(bookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(booking);
        } catch (BookingConflitException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getBookingAvailabelDto());
        }
    }

    @ApiOperation(value = "deleteBooking")
    @ApiResponses(value = {
        @ApiResponse(code = 202, message = "Accepted", response = RoomDto.class),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Failure")})
    @DeleteMapping("/{idBooking}")
    public ResponseEntity<BookingDto> deleteBooking(@PathVariable String idBooking) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookingService.deleteBooking(idBooking));
    }
}