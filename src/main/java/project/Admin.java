package project;

import java.util.*;
public class Admin {

	static ArrayList<Booking> AppointmentList = new ArrayList<>();
	static ArrayList<Patient> PatientList = new ArrayList<>();
	static ArrayList<Doctor> DoctorList = new ArrayList<>();
	static ArrayList<String> addPatientToDoctorList = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	
	
	public void AddPatient(String name, String age, String description, String department) {
	    int id = PatientList.size() + 1;
	    Patient patientObject = new Patient(id, name, age, description, department);
	    PatientList.add(patientObject);
	}
	
	public void AddPatient() {
		int id = PatientList.size()+1;
		System.out.print("Enter the patient name : ");
		String name = in.next();
		System.out.print("Enter the patient age : ");
		String age = in.next();
		System.out.print("Enter the patient Description : ");
		String Description = in.next();
		System.out.print("Enter the patient Department : ");
		String department = in.next();
		Patient PatientObject = new Patient(id, name, age, Description,department);
		PatientList.add(PatientObject);
	}
	public boolean deletePatient() {
		System.out.print("Enter the patient name : ");
		String name = in.next();
		
		for(Patient x : PatientList) {
			if(x.getPatientName().equals(name)) {
				PatientList.remove(x);
				return true;
			}
		}
		return false;
		
	}
	public boolean deletePatient(String name) {
	    for (int i = 0; i < PatientList.size(); i++) {
	        if (PatientList.get(i).getPatientName().equals(name)) {
	            PatientList.remove(i);
	            return true; // Patient was found and removed
	        }
	    }
	    return false; // No patient found with the given name
	}
	
	
	
	public boolean editPatient() {
	    System.out.print("Enter the name of the patient you want to edit: ");
	    String name = in.next();
	    boolean found = false;
	    if(!PatientList.isEmpty()) {
	    for (Patient patient : PatientList) {
	        if (patient.getPatientName().equals(name)) {
	            
	            System.out.println("Patient found. Enter new information:");

	            System.out.print("Enter the patient name: ");
	            String Newname = in.next();
	            System.out.print("Enter the patient age: ");
	            String age = in.next();
	            System.out.print("Enter the patient description: ");
	            String description = in.next();
	            System.out.print("Enter the patient department: ");
	            String department = in.next();

	            patient.setPatientName(name);
	            patient.setPatientAge(age);
	            patient.setPatientDescription(description);
	            patient.setPatientDepartment(department);

	            System.out.println("Patient information updated successfully.");
	            
	            return true;
	        }
	    }
	    }

	 return false;
	}
	/*used in testing for automating input */
	public boolean editPatient(String existingName, String newName, String newAge, String newDescription, String newDepartment) {
	    for (Patient patient : PatientList) {
	        if (patient.getPatientName().equals(existingName)) {
	            
	            // Assuming validation of new details is done before or within this method
	            patient.setPatientName(newName);
	            patient.setPatientAge(newAge);
	            patient.setPatientDescription(newDescription);
	            patient.setPatientDepartment(newDepartment);

	            System.out.println("Patient information updated successfully.");
	            return true; // Patient found and updated
	        }
	    }
	    System.out.println("Patient not found.");
	    return false; // Patient not found
	}

	
	
	public void AddDoctor() {
		int id = DoctorList.size()+1;
		System.out.print("Enter the doctor name : ");
		String name = in.next();
		System.out.print("Enter the doctor password : ");
		String password = in.next();
		System.out.print("Enter the doctor specialization : ");
		String specialization = in.next();
		
		Doctor DoctorObject = new Doctor(id, name, password,specialization);
		DoctorList.add(DoctorObject);
	}
	/*used in testing for automating input */
	public void addDoctor(String name, String password, String specialization) {
	    int id = DoctorList.size() + 1;
	    Doctor doctorObject = new Doctor(id, name, password, specialization);
	    DoctorList.add(doctorObject);
	}
	
	
	public boolean searchPatient(String patientName) {
		if(!PatientList.isEmpty()) {
			for(Patient x : PatientList) {
				if(x.getPatientName().equals(patientName)) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean searchDoctor(String DoctorName) {
		if(!DoctorList.isEmpty()) {
			for(Doctor x : DoctorList) {
				if(x.getDoctorName().equals(DoctorName)) {
					return true;
				}
			}
		}
		return false;
	}
	public void registerPatientToDoctor() {
		int id = AppointmentList.size() + 1;
		
		System.out.print("Enter patient name :");
		String patientName = in.next();
		
		System.out.println("Enter Doctor name : ");
		String doctorName = in.next();
		if(searchPatient(patientName)&&searchDoctor(doctorName)) {
			Booking appointment = new Booking(id, patientName, doctorName);
			AppointmentList.add(appointment);
		}else {
			System.out.println("Invalid Patient or Doctor");
		}
	}
	/*used in testing for automating input */
	public boolean registerPatientToDoctor(String patientName, String doctorName) {
	    // First, check if the patient and doctor exist
	    boolean patientExists = searchPatient(patientName);
	    boolean doctorExists = searchDoctor(doctorName);

	    if (patientExists && doctorExists) {
	        // Generate a new appointment ID based on the size of the AppointmentList
	        int id = AppointmentList.size() + 1;
	        
	        // Create and add the new appointment to the list
	        Booking appointment = new Booking(id, patientName, doctorName);
	        AppointmentList.add(appointment);
	        
	        return true; // Indicate successful registration
	    } else {
	        // If either the patient or doctor doesn't exist, registration fails
	        return false;
	    }
	}
	public void viewAppointments() {
		for(Booking x: AppointmentList ) {
			System.out.print(x.toString());
		}
	}
	
	public String viewPatients() {
	    StringBuilder patientsString = new StringBuilder();
	    for (Patient patient : PatientList) {
	        patientsString.append(patient.toString()).append("\n");
	    }
	    return patientsString.toString();
	}
	public boolean loginAsDoctor(String doctorName, String doctorPassword) {
		for(Doctor x :DoctorList) {
			if(x.getDoctorName().equals(doctorName) && x.getPassword().equals(doctorPassword)) {
				return true;
			}
			
		}
		return false;
	}
	public boolean deletePatientFromSpecificDoctor() {
	viewAppointments () ;
	System.out.println("Enter appoinment id to delete from doctor : ");
	int id = in.nextInt ();
	for (Booking x : AppointmentList) {
	if (x.getAppointmentID() == id) {
	AppointmentList. remove (x) ;
	return true ;
	}
	}
	return false ;
	
	}
	
	public boolean deletePatientFromSpecificDoctor(int appointmentId) {
	    for (int i = 0; i < AppointmentList.size(); i++) {
	        Booking booking = AppointmentList.get(i);
	        if (booking.getAppointmentID() == appointmentId) {
	            AppointmentList.remove(i); // Remove the appointment by index
	            return true; // Indicate successful deletion
	        }
	    }
	    return false; // Appointment not found, indicating deletion was unsuccessful
	}

	public String viewBookingToDoctor(String doctorName) {
	    StringBuilder bookingsString = new StringBuilder();
	    for (Booking booking : AppointmentList) {
	        if (booking.getDoctorName().equals(doctorName)) {
	            bookingsString.append(booking.toString()).append("\n");
	        }
	    }
	    return bookingsString.toString();
	}
	
	public boolean appointmentExists(String patientName, String doctorName) {
	    for (Booking booking : AppointmentList) {
	        if (booking.getPatientName().equals(patientName) && booking.getDoctorName().equals(doctorName)) {
	            return true; // Appointment exists
	        }
	    }
	    return false; // No such appointment found
	}
	
}
