package project;

import java.util.Scanner;


public class main {

	static Admin admin = new Admin();
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("------Welcome Login with------");
				System.out.println ("1.Admin");
				System. out.println ("2.Doctor");
				System. out.println ("3.Exit");
				
				while (true) {
					System.out.print("Enter the login number : ");
					int choice = in.nextInt();
					switch(choice) {
					case 1:{
						System.out.println("Enter user name as admin : ");
								String userName = in.next();
								System.out.println("Enter passwordas admin : ");
								String password = in.next();
								if(userName.equals("Admin") && password.equals("Admin")) {
									System.out.println("----Admin Choice------");
									System.out.println("1. Add Patient");
									System.out.println("2. Add Doctor");
									System.out.println("3. Search Patient");
									System.out.println("4. Delete Patient");
									System.out.println("5. Update Patient");
									System.out.println("6. View Patients");
									System.out.println("7. Register a patient to specific doctor");
									System.out.println("8. View Booking");
									System.out.println("9. Main menu");
									while(true) {
										System.out.print("Enter choice number");
										int choice2 = in.nextInt();
										switch(choice2) {
										case 1 :
											admin.AddPatient();
											break;
										case 2:
											admin.AddDoctor();
											break;
										case 3:
											  System.out.println("Enter Patient name to search : ");
											  String patientName = in.next();
											  if(admin.searchPatient(patientName)) {
												  System.out.println("Is available");  
											  }else {
												  System.out.println("Not available");
											  }
											  break;
										case 4:
											if(admin.deletePatient()) {
												System.out.println("Deleted");
											}else {
												System.out.println("Not found");
											}
											break;
										case 5:
											if(admin.editPatient()) {
												System.out.println("Edited");
											}else {
												System.out.println("Not found");
											}
											break;
										case 6:
											admin.viewPatients();
											break;
										case 7:
											admin.registerPatientToDoctor();
											break;
										case 8:
											admin.viewAppointments();
											break;
										case 9: 
											main(args);
											break;
						
											
										
										}
									}
								}else {
									System.out.println("You are not admin");
									
								}break;
					}
					case 2:{
						System.out.println("Login As a Doctor");
						System.out.println("Enter Doctor name : ");
						String doctorName = in.next();
						System.out.println("Enter Doctor password : ");
						String doctorPassword = in.next();
						if(admin.loginAsDoctor(doctorName, doctorPassword)) {
							System.out.println("----------Doctor--------");
							System.out.println("1. Delete patient from this doctor");
							System.out.println("2. show patients to this doctor");
							System.out.println("3. main menu");
		
						
						while(true) {
							System.out.println("Select a choice");
							int choice3 = in.nextInt();
							switch (choice3) {
							case 1:
								if(admin.deletePatientFromSpecificDoctor()) {
									System.out.println("Deleted");
								} else {
									System.out.println("Not Deleted");
								}
								break;
							case 2:
								System.out.println(admin.viewBookingToDoctor(doctorName));
								break;
							case 3:
								main(args);
								break;
							}
						}
						
					} else {System.out.println("Doctor is not available");}
						
						
					}
					break;
					case 3: System.exit(0);
					break;
				}
				

	}
	}

}
