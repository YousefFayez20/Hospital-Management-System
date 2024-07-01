package project;

import static org.junit.jupiter.api.Assertions.*;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.DisplayName;
	import org.junit.jupiter.api.Order;
	import org.junit.jupiter.api.Test;

class PatientTest {

     	@Test
		@Order(1)
		@DisplayName("Test get Patient's ID")
		public void testsetPatientID() {
		    Patient patient =new Patient(40206,"Yousef","30","Headache","emergency");
			assertEquals(40206,patient.getPatientID());
		}
		@Test
		@Order(2)
		@DisplayName("Test get Patient's Name")
		public void testsetPatientName() {
		    Patient patient =new Patient(40206,"Yousef","30","Headache","emergency");
			assertEquals("Yousef",patient.getPatientName());
		}
		@Test
		@Order(3)
		@DisplayName("Test get Doctor's Age")
		public void testsetDoctorAge() {
		    Patient patient =new Patient(40206,"Yousef","30","Headache","emergency");
			assertEquals("30",patient.getPatientAge());
		}
		@Test
		@Order(4)
		@DisplayName("Test get Patient's Desription")
		public void testsetDoctorDesription() {
			   Patient patient =new Patient(40206,"Yousef","30","Headache","emergency");
				assertEquals("Headache",patient.getPatientDescription());
		}
		@Test
		@Order(5)
		@DisplayName("Test get Patient's Department")
		public void testsetDoctorDepartment() {
			   Patient patient =new Patient(40206,"Yousef","30","Headache","emergency");
				assertEquals("emergency",patient.getPatientDepartment());
		}
}
