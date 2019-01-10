package demo.kataapi.demo.service;

import demo.kataapi.demo.service.dto.BookingDto;
import demo.kataapi.demo.service.dto.BookingRequestDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.format.DateTimeParseException;
import java.util.SortedSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTest {

    @Autowired
    IBookingService bookingService;

    BookingRequestDto bookingRequestDto;

    @Before
    public void setUp() throws Exception {
        bookingRequestDto = new BookingRequestDto();
        bookingRequestDto.setStartTime(8);
        bookingRequestDto.setEndTime(9);
        bookingRequestDto.setPersonName("TEST");
        bookingRequestDto.setIdRoom("0");
        bookingRequestDto.setDate("20190101");
    }

    @Test
    public void findBooking() {
        BookingDto bookingExpected = bookingService.createBooking(bookingRequestDto);
        BookingDto booking = bookingService.findBooking(bookingExpected.getIdTech());
        Assert.assertEquals(bookingExpected.getIdTech(), booking.getIdTech());
    }

    @Test
    public void deleteBooking() {
        BookingDto bookingExpected = bookingService.createBooking(bookingRequestDto);
        BookingDto booking = bookingService.deleteBooking(bookingExpected.getIdTech());
        Assert.assertEquals(bookingExpected.getIdTech(), booking.getIdTech());

        try {
            bookingService.findBooking(bookingExpected.getIdTech());
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            Assert.assertNotNull(e);
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void createBooking_idRoomNull() {
        bookingService.createBooking(new BookingRequestDto());
    }

    @Test(expected = DateTimeParseException.class)
    public void createBooking_dateInvalid() {
        BookingRequestDto bookingRequestDto = new BookingRequestDto();
        bookingRequestDto.setDate("20191332");
        bookingService.createBooking(bookingRequestDto);
    }

    @Test
    public void createBooking() {
        bookingService.createBooking(bookingRequestDto);
    }

    @Test
    public void listAvailableBookings() {
        bookingService.createBooking(bookingRequestDto);

        SortedSet<Integer> listAvailableBookings = bookingService.listAvailableBookings("0", "20190101");
        Assert.assertEquals(23, listAvailableBookings.size());
    }
}