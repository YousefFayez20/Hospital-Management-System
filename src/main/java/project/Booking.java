package project;

public class Booking {

	private int AppointmentID;
	private String PatientName;
	private String DoctorName;
	public Booking(int appointmentID, String patientName, String doctorName) {
		
		this.AppointmentID = appointmentID;
		this.PatientName = patientName;
		this.DoctorName = doctorName;
	}
	public int getAppointmentID() {
		return AppointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		AppointmentID = appointmentID;
	}
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
	@Override
	public String toString() {
		return "Booking [AppointmentID=" + AppointmentID + ", PatientName=" + PatientName + ", DoctorName=" + DoctorName
				+ "]";
	}
	
	
	
}

