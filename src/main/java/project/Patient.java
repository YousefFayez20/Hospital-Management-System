package project;

public class Patient {
private int PatientID;
private String PatientName;
private String PatientAge;
private String PatientDescription;
private String PatientDepartment;
public Patient() {
	
}
public Patient(int patientID, String PatientName, String patientAge, String patientDescription,
		String patientDepartment) {

	this.PatientID = patientID;
	this.PatientName = PatientName;
	this.PatientAge = patientAge;
	this.PatientDescription = patientDescription;
	this.PatientDepartment = patientDepartment;
}
public int getPatientID() {
	return PatientID;
}
public void setPatientID(int patientID) {
	PatientID = patientID;
}
public String getPatientName() {
	return PatientName;
}
public void setPatientName(String PatientName) {
	this.PatientName = PatientName;
}
public String getPatientAge() {
	return PatientAge;
}
public void setPatientAge(String patientAge) {
	PatientAge = patientAge;
}
public String getPatientDescription() {
	return PatientDescription;
}
public void setPatientDescription(String patientDescription) {
	PatientDescription = patientDescription;
}
public String getPatientDepartment() {
	return PatientDepartment;
}
public void setPatientDepartment(String patientDepartment) {
	PatientDepartment = patientDepartment;
}
@Override
public String toString() {
	return "Patient [PatientID=" + PatientID + ", PatentName=" + PatientName + ", PatientAge=" + PatientAge
			+ ", PatientDescription=" + PatientDescription + ", PatientDepartment=" + PatientDepartment + "]";
}




}

