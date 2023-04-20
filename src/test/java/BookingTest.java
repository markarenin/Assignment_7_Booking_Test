import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookingTest {
    private Booking booking;
    private Booking mockBooking;

    @BeforeEach
    public void setUp() {
        booking = new BookingImpl();
        mockBooking = Mockito.mock(Booking.class);
    }

    @Test
    public void testCalculateCost() {
        when(mockBooking.calculateCost("standard", 3)).thenReturn(300.0);
        double cost = mockBooking.calculateCost("standard", 3);
        assertEquals(300.0, cost, 0.01);
    }

    @Test
    public void testBook() {
        Booking spyBooking = Mockito.spy(booking);

        String roomType = "deluxe";
        int duration = 5;

        doReturn("Success").when(spyBooking).book(roomType, duration);
        assertEquals("Success", spyBooking.book(roomType, duration));
    }

    @Test
    public void testFakeBooking() {
        Booking fakeBooking = new FakeBooking();
        String roomType = "standard";
        int duration = 2;
        assertEquals("Booked", fakeBooking.book(roomType, duration));
    }
}