package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class BookingTest {

	@Test
	@DisplayName("Test the Booking Constructor")
	public void testBookingConstructor() {
		Booking booking = new Booking(1, "Hasnaa Khaled", "Aya Mohamed");
        assertNotNull(booking);
        assertEquals(1, booking.getAppointmentID());
        assertEquals("Hasnaa Khaled", booking.getPatientName());
        assertEquals("Aya Mohamed", booking.getDoctorName());
	}
	    @Test
	    @DisplayName("Test Getters and Setters")
	    void testGettersAndSetters() {
	        Booking booking = new Booking(1, "Ali Sherif", "Mohamed Zaki");

	        // Test setters
	        booking.setAppointmentID(2);
	        assertEquals(2, booking.getAppointmentID(), "Setter for appointment ID failed");

	        booking.setPatientName("Abdulrahman Nabil");
	        assertEquals("Abdulrahman Nabil", booking.getPatientName());

	        booking.setDoctorName("Dr. Shady");
	        assertEquals("Dr. Shady", booking.getDoctorName());

	        // Test getters
	        int id = booking.getAppointmentID();
	        assertEquals(2, id, "Getter for appointment ID failed");

	        String patientName = booking.getPatientName();
	        assertEquals("Abdulrahman Nabil", patientName, "Getter for patient name failed");

	        String doctorName = booking.getDoctorName();
	        assertEquals("Dr. Shady", doctorName, "Getter for doctor name failed");
	    }

	    @Test
	    @DisplayName("Test the toString Method")
	    void testToString() {
	        Booking booking = new Booking(1, "Abdulrahman Nabil", "Dr. Shady");
	        String expectedString = "Booking [AppointmentID=1, PatientName=Abdulrahman Nabil, DoctorName=Dr. Shady]";
	        assertEquals(expectedString, booking.toString());
	    }
}
