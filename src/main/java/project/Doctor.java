package project;

public class Doctor {

    private int doctorID;
    private String doctorName;
    private String password;
    private String docSpecialization;
 
	public Doctor() {

	}
	public Doctor(int doctorID, String doctorName, String password, String docSpecialization) {
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.password = password;
		this.docSpecialization = docSpecialization;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDocSpecialization() {
		return docSpecialization;
	}
	public void setDocSpecialization(String docSpecialization) {
		this.docSpecialization = docSpecialization;
	}
	@Override
	public String toString() {
		return "Doctor [doctorID=" + doctorID + ", doctorName=" + doctorName + ", password=" + password
				+ ", docSpecialization=" + docSpecialization + "]";
	}
	
	
	
	
}

