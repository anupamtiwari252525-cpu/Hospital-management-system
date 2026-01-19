package com.jdbcconnectivity.HospitalManagement;

import com.jdbcconnectivity.HospitalManagement.model.*;
import com.jdbcconnectivity.HospitalManagement.service.*;
import com.jdbcconnectivity.HospitalManagement.service.impl.*;

import java.sql.Date;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    static PatientService patientService = new PatientServiceImpl();
    static DoctorService doctorService = new DoctorServiceImpl();
    static AppointmentService appointmentService = new AppointmentServiceImpl();
    static AdmissionService admissionService = new AdmissionServiceImpl();
    static BillingService billingService = new BillingServiceImpl();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Admit Patient");
            System.out.println("8. Discharge Patient");
            System.out.println("9. Generate Bill");
            System.out.println("10. View Bills");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    addDoctor();
                    break;

                case 4:
                    viewDoctors();
                    break;

                case 5:
                    bookAppointment();
                    break;

                case 6:
                    viewAppointments();
                    break;

                case 7:
                    admitPatient();
                    break;

                case 8:
                    dischargePatient();
                    break;

                case 9:
                    generateBill();
                    break;

                case 10:
                    viewBills();
                    break;

                case 11:
                    System.out.println("Application exited.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= PATIENT =================

    static void registerPatient() {
        sc.nextLine();
        Patient p = new Patient();

        System.out.print("Name: ");
        p.setName(sc.nextLine());
        System.out.print("Age: ");
        p.setAge(sc.nextInt());
        sc.nextLine();
        System.out.print("Gender: ");
        p.setGender(sc.nextLine());
        System.out.print("Phone: ");
        p.setPhone(sc.nextLine());
        System.out.print("Address: ");
        p.setAddress(sc.nextLine());

        patientService.registerPatient(p);
        System.out.println("Patient registered successfully!");
    }

    static void viewPatients() {
        for (Patient p : patientService.getAllPatients()) {
            System.out.println(
                    p.getPatientId() + " | " +
                    p.getName() + " | " +
                    p.getAge() + " | " +
                    p.getGender()
            );
        }
    }

    // ================= DOCTOR =================

    static void addDoctor() {
        sc.nextLine();
        Doctor d = new Doctor();

        System.out.print("Name: ");
        d.setName(sc.nextLine());
        System.out.print("Specialization: ");
        d.setSpecialization(sc.nextLine());
        System.out.print("Phone: ");
        d.setPhone(sc.nextLine());

        doctorService.addDoctor(d);
        System.out.println("Doctor added successfully!");
    }

    static void viewDoctors() {
        for (Doctor d : doctorService.getAllDoctors()) {
            System.out.println(
                    d.getDoctorId() + " | " +
                    d.getName() + " | " +
                    d.getSpecialization()
            );
        }
    }

    // ================= APPOINTMENT =================

    static void bookAppointment() {
        Appointment a = new Appointment();

        System.out.print("Patient ID: ");
        a.setPatientId(sc.nextInt());
        System.out.print("Doctor ID: ");
        a.setDoctorId(sc.nextInt());

        a.setAppointmentDate(new Date(System.currentTimeMillis()));
        appointmentService.bookAppointment(a);

        System.out.println("Appointment booked successfully!");
    }

    static void viewAppointments() {
        for (Appointment a : appointmentService.getAllAppointments()) {
            System.out.println(
                    a.getAppointmentId() +
                    " | Patient: " + a.getPatientId() +
                    " | Doctor: " + a.getDoctorId() +
                    " | Date: " + a.getAppointmentDate()
            );
        }
    }

    // ================= ADMISSION =================

    static void admitPatient() {
        Admission a = new Admission();

        System.out.print("Patient ID: ");
        a.setPatientId(sc.nextInt());
        sc.nextLine();
        System.out.print("Room No: ");
        a.setRoomNo(sc.nextLine());

        a.setAdmissionDate(new Date(System.currentTimeMillis()));
        admissionService.admitPatient(a);

        System.out.println("Patient admitted successfully!");
    }

    static void dischargePatient() {
        System.out.print("Admission ID: ");
        int id = sc.nextInt();

        admissionService.dischargePatient(id);
        System.out.println("Patient discharged successfully!");
    }

    // ================= BILLING =================

    static void generateBill() {
        Billing b = new Billing();

        System.out.print("Patient ID: ");
        b.setPatientId(sc.nextInt());
        System.out.print("Amount: ");
        b.setAmount(sc.nextDouble());

        b.setBillDate(new Date(System.currentTimeMillis()));
        b.setStatus("UNPAID");

        billingService.generateBill(b);
        System.out.println("Bill generated successfully!");
    }

    static void viewBills() {
        for (Billing b : billingService.getAllBills()) {
            System.out.println(
                    b.getBillId() +
                    " | Patient: " + b.getPatientId() +
                    " | Amount: " + b.getAmount() +
                    " | Status: " + b.getStatus()
            );
        }
    }
}
