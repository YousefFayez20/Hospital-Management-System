package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
    private JFrame loginFrame;
    private JFrame adminFrame;
    private JFrame doctorFrame;

    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JButton addPatientButton;
    private JButton addDoctorButton;
    private JButton searchPatientButton;
    private JButton deletePatientButton;
    private JButton editPatientButton;
	private JButton viewPatientsButton;
	private JButton registerPatientButton;
	private JButton viewBookingButton;
	private JButton mainMenuButton;

	private JButton deletePatient;
	private JButton showPatients;
	private JButton mainMenuButton1;

    private Admin admin;
    private Doctor doctor;

    public gui() {
        admin = new Admin();
        doctor = new Doctor();

        initComponents();
    }

    private void initComponents() {
        // Login frame
        loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(300, 150);
        loginFrame.setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        loginFrame.add(loginPanel);

        // Admin frame
        adminFrame = new JFrame("Admin Dashboard");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setSize(800, 400);
        adminFrame.setLocationRelativeTo(null);

        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(3, 3));

        addPatientButton = new JButton("Add Patient");
        addDoctorButton = new JButton("Add Doctor");
        searchPatientButton = new JButton("Search Patient");
        deletePatientButton = new JButton("Delete Patient");
        editPatientButton = new JButton("Edit Patient");
    	viewPatientsButton = new JButton("View Patients");
    	registerPatientButton = new JButton("Register Patient to Doctor");
    	viewBookingButton = new JButton("View Booking");
    	mainMenuButton = new JButton("Main Menu");
    	
        adminPanel.add(addPatientButton);
        adminPanel.add(addDoctorButton);
        adminPanel.add(searchPatientButton);
        adminPanel.add(deletePatientButton);
        adminPanel.add(editPatientButton);
        adminPanel.add(viewPatientsButton);
        adminPanel.add(registerPatientButton);
        adminPanel.add(viewBookingButton);
        adminPanel.add(mainMenuButton);

        adminFrame.add(adminPanel);

        // Doctor frame
        doctorFrame = new JFrame("Doctor Dashboard");
        doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doctorFrame.setSize(400, 200);
        doctorFrame.setLocationRelativeTo(null);

        JPanel doctorPanel = new JPanel();
        doctorPanel.setLayout(new GridLayout(1, 2));
        
        deletePatient = new JButton("Delete Patient");
        showPatients = new JButton("Show Patients");
        mainMenuButton1 = new JButton("Main Menu");
        
        //doctorPanel.add(mainMenuButton);
        doctorPanel.add(deletePatient);
        doctorPanel.add(showPatients);
        doctorPanel.add(mainMenuButton1);
        
        doctorFrame.add(doctorPanel);

        // Login button action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (username.equals("Admin") && password.equals("Admin")) {
                    loginFrame.setVisible(false);
                    adminFrame.setVisible(true);
                } else if (admin.loginAsDoctor(username, password)) {
                    loginFrame.setVisible(false);
                    doctorFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid username or password. Please try again.");
                }

                // Clear the username and password fields
                //usernameTextField.setText("");
                //passwordField.setText("");
            }
        });

        // Add patient button action
        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = JOptionPane.showInputDialog(adminFrame, "Enter patient name:");
                String patientAge = JOptionPane.showInputDialog(adminFrame, "Enter patient age:");
                String patientDescription = JOptionPane.showInputDialog(adminFrame, "Enter patient description:");
                String patientDepartment = JOptionPane.showInputDialog(adminFrame, "Enter patient department:");

                admin.AddPatient(patientName, patientAge, patientDescription, patientDepartment);
                JOptionPane.showMessageDialog(adminFrame, "Patient added successfully.");
            }
        });
        
        // Add doctor button action
        addDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorName = JOptionPane.showInputDialog(adminFrame, "Enter Doctor name:");
                String doctorPassword = JOptionPane.showInputDialog(adminFrame, "Enter Doctor Password:");
                String doctorSpecialization = JOptionPane.showInputDialog(adminFrame, "Enter Doctor Specialization:");

                admin.addDoctor(doctorName, doctorPassword, doctorSpecialization);
                JOptionPane.showMessageDialog(adminFrame, "Doctor added successfully.");
            }
        });
        
        // Search patient button action
        searchPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = JOptionPane.showInputDialog(adminFrame, "Enter patient name:");
                boolean patient = admin.searchPatient(patientName);

                if (patient != false) {
                    JOptionPane.showMessageDialog(adminFrame, "Patient found:\n");
                } else {
                    JOptionPane.showMessageDialog(adminFrame, "Patient not found.");
                }
            }
        });

        // Delete patient button action
        deletePatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = JOptionPane.showInputDialog(adminFrame, "Enter patient name:");

                boolean result = admin.deletePatient(patientName);

                if (result) {
                    JOptionPane.showMessageDialog(adminFrame, "Patient deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(adminFrame, "Patient not found.");
                }
            }
        });

        // Edit patient button action
        editPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = JOptionPane.showInputDialog(adminFrame, "Enter patient name:");
                //Patient patient = admin.searchPatient(patientName);
                boolean patient1 = admin.searchPatient(patientName);

                if (patient1 != false) {
                    String newPatientName = JOptionPane.showInputDialog(adminFrame, "Enter new patient name:");
                    String newPatientAge = JOptionPane.showInputDialog(adminFrame, "Enter new patient age:");
                    String newPatientDescription = JOptionPane.showInputDialog(adminFrame, "Enter new patient description:");
                    String newPatientDepartment = JOptionPane.showInputDialog(adminFrame, "Enter new patient department:");

                    admin.editPatient(patientName, newPatientName, newPatientAge, newPatientDescription, newPatientDepartment);
                    JOptionPane.showMessageDialog(adminFrame, "Patient information updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(adminFrame, "Patient not found.");
                }
            }
        });
        
        // View patients button action
        viewPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patients = admin.viewPatients();   
                if (!patients.isEmpty()) {
                	JOptionPane.showMessageDialog(adminFrame, patients);
                } else {
                    JOptionPane.showMessageDialog(adminFrame, "Patients not found.");
                }
            }
        });

        // Register patient to doctor button action
        registerPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = JOptionPane.showInputDialog(adminFrame, "Enter patient name:");
                String doctorName = JOptionPane.showInputDialog(adminFrame, "Enter doctor name:");

                boolean registered = admin.registerPatientToDoctor(patientName, doctorName);

                if (registered) {
                    JOptionPane.showMessageDialog(adminFrame, "Patient registered to doctor successfully.");
                } else {
                    JOptionPane.showMessageDialog(adminFrame, "Patient or doctor not found.");
                }
            }
        });

        // View booking button action
        viewBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorName = JOptionPane.showInputDialog(adminFrame, "Enter doctor name:");
                String bookings = admin.viewBookingToDoctor(doctorName);           

                if (!bookings.isEmpty()) {
                    JOptionPane.showMessageDialog(adminFrame, bookings);
                } else {
                    JOptionPane.showMessageDialog(adminFrame, "Doctor not found or no bookings available.");
                }
            }
        });

        // Main menu button action
        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.setVisible(false);
                loginFrame.setVisible(true);
            }
        });
        
        // Main menu button action
        mainMenuButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctorFrame.setVisible(false);
                loginFrame.setVisible(true);
            }
        });
        
     // Delete patient button action
        deletePatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patientName = JOptionPane.showInputDialog(doctorFrame, "Enter Appointment ID name:");
                int id = Integer.parseInt(patientName);
                boolean result = admin.deletePatientFromSpecificDoctor(id);

                if (result) {
                    JOptionPane.showMessageDialog(doctorFrame, "Patient deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(doctorFrame, "Patient not found.");
                }
            }
        });

        // Show patients button action
        showPatients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String patients = admin.viewBookingToDoctor(usernameTextField.getText());

                if (!patients.isEmpty()) {
                    JOptionPane.showMessageDialog(doctorFrame, patients);
                } else {
                    JOptionPane.showMessageDialog(doctorFrame, "No patients found.");
                }
            }
        });
     }

    public void show() {
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui mainGUI = new gui();
                mainGUI.show();
            }
        });
    }
}
