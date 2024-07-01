package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class DoctorTest {
	@Test
	@Order(1)
	@DisplayName("Test get Doctor's ID")
	public void testsetDoctorID() {
	    Doctor doctor =new Doctor(30206,"Yousef","45697","Cardiology");
		assertEquals(30206,doctor.getDoctorID());
	}
	@Test
	@Order(2)
	@DisplayName("Test get Doctor's Name")
	public void testsetDoctorName() {
		Doctor doctor =new Doctor(30207,"Amr Mohamed","67592"," Family Medicine");
		assertEquals("Amr Mohamed",doctor.getDoctorName());
	}
	@Test
	@Order(3)
	@DisplayName("Test get Doctor's password")
	public void testsetDoctorPassword() {
		Doctor doctor =new Doctor(30208,"Ali Ayman","65869","Surgery");
		assertEquals("65869",doctor.getPassword());
	}
	@Test
	@Order(4)
	@DisplayName("Test get Doctor's Specialization")
	public void testsetDoctorSpecialization() {
		Doctor doctor =new Doctor(30208,"Ali Ayman","65869","Surgery");
		assertEquals("Surgery",doctor.getDocSpecialization());
	}
	

}

