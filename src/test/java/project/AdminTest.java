package project;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class AdminTest {
	 private Admin admin;

	    @BeforeEach
	    public void setup() {
	        admin = new Admin();
	    }

	    @Test
	    @DisplayName("Test Add and search for Patient")
	    public void testAddAndSearchPatient() {
	        admin.AddPatient("Karim Ghaly", "30", "Flu", "General Medicine");
	        assertTrue(admin.searchPatient("Karim Ghaly"));
	    }
	    @Test
	    @DisplayName("Test Add and search for Doctor")
	    public void testAddAndSearchDoctor() {
	        admin.addDoctor("Dr. Ali", "password123", "Cardiology");
	        assertTrue(admin.searchDoctor("Dr. Ali"));
	    }
	    @Test
	    @DisplayName("Test Login As a doctor")
	    public void testLoginAsDoctor() {
	        admin.addDoctor("Dr. Omar", "password123", "Cardiology");
	        assertTrue(admin.loginAsDoctor("Dr. Omar", "password123"));
	        assertFalse(admin.loginAsDoctor("Dr. Omar", "wrongpassword"));
	    }
	    @Test
	    @DisplayName("Test Login As a doctor again")
	    public void testDoctorLogin() {
	        admin.addDoctor("Dr. Alia", "elementary", "Dermatology");
	        assertTrue(admin.loginAsDoctor("Dr. Alia", "elementary"));
	        assertFalse(admin.loginAsDoctor("Dr. Alia", "incorrectPassword"));
	    }
	    @Test
	    @DisplayName("Test Edit a Patient")
	    public void testEditPatient() {
	        admin.AddPatient("Mark Refaat", "30", "Flu", "General Medicine");
	        assertTrue(admin.editPatient("Mark Refaat", "Mark Refaat", "31", "Mild Flu", "General Medicine"));
	        
	    }
	    @Test
	    @DisplayName("Test Register Patient To Doctor And View Appointments")
	    public void testRegisterPatientToDoctorAndViewAppointments() {
	        admin.AddPatient("Mohamed Barakat", "25", "Cold", "General Medicine");
	        admin.addDoctor("Dr. Osama", "password123", "Cardiology");
	        admin.registerPatientToDoctor("Mohamed Barakat", "Dr. Osama");
	        assertTrue(admin.appointmentExists("Mohamed Barakat", "Dr. Osama"));
	        
	    }
	    @Test
	    @DisplayName("test Delete Patient From Specific Doctor")
	    public void testDeletePatientFromSpecificDoctor() {
	        admin.AddPatient("Goerge Ayman", "40", "Cough", "Pulmonology");
	        admin.addDoctor("Dr. Gamil", "securePass", "Pulmonology");
	        admin.registerPatientToDoctor("Goerge Ayman", "Dr. Gamil");
	        int appointmentId =admin.AppointmentList.size(); 
	        assertTrue(admin.deletePatientFromSpecificDoctor(appointmentId));
	        assertFalse(admin.appointmentExists("Goerge Ayman", "Dr. Gamil"));
	        
	    }
	    @Test
	    @DisplayName("Test Editing a patient")
	    void testEditPatientInformation() {
	        admin.AddPatient("Ahmed Ibrahim", "30", "Flu", "General Medicine");
	        assertTrue(admin.editPatient("Ahmed Ibrahim", "Ahmed Yousef", "31", "Severe Flu", "Infectious Diseases"));
	        assertTrue(admin.searchPatient("Ahmed Yousef"));
	        
	    }
	    @Test
	    @DisplayName("Test deleting a patient")
	    void testDeleteExistingPatient() {
	    	admin.AddPatient("Ahmed Rageb", "30", "Flu", "General Medicine");
	        admin.AddPatient("Sayed Osama", "25", "Cold", "Pediatrics");
	        assertTrue(admin.deletePatient("Ahmed Rageb"));
	        assertFalse(admin.searchPatient("Ahmed Rageb"));
	    }
	    @Test
	    @DisplayName("Test registering a patient to a doctor when one of them does not exist")
	    void testRegisterPatientToNonexistentDoctor() {
	        admin.AddPatient("Hossam Ahmed", "25", "Cold", "General Medicine");
	        admin.addDoctor("Dr. Mohamed", "securePass", "Pulmonology");
	        assertFalse(admin.registerPatientToDoctor("Hossam Ahmed", "Dr. Ahmed"));
	    }
	    @Test
	    @DisplayName("Test unsuccessful login attempts for a doctor")
	    void testUnsuccessfulDoctorLogins() {
	        admin.addDoctor("Dr. Ali", "secure123", "Neurology");
	        assertFalse(admin.loginAsDoctor("Dr. Ali", "secure124"));
	        assertFalse(admin.loginAsDoctor("Dr. Sherif", "secure123"));
	    }

	


}

