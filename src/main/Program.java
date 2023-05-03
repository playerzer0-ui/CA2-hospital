package main;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;
import util.Appointment;
import util.HashMap;
import util.Patient;
import util.PriorityQueue;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        HashMap patients;

        File dataFile = new File("data.bin");
        if(dataFile.exists()){
            FileInputStream file = new FileInputStream(dataFile);
            try {
                ObjectInputStream bin = new ObjectInputStream(file);
                patients = (HashMap) bin.readObject();
            } catch (EOFException e) {
                patients = new HashMap();
            }
        }
        else{
            patients = new HashMap();
        }

        PriorityQueue queue = new PriorityQueue();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flag = false;

        while (!flag) {
            menu();
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        if (addPatient(patients)) {
                            System.out.println("patient added successfully!");
                        } else {
                            System.out.println("patient failed to be added");
                        }
                        break;
                    case 2:
                        if (deletePatient(patients)) {
                            System.out.println("patient removed successfully!");
                        } else {
                            System.out.println("patient failed to be removed");
                        }
                        break;
                    case 3:
                        System.out.println(patients);
                        break;
                    case 4:
                        if (newAppointment(patients, queue)) {
                            System.out.println("appointment added successfully!");
                        } else {
                            System.out.println("appointment failed to create");
                        }
                        break;
                    case 5:
                        Appointment next = queue.peek();
                        if (next != null) {
                            System.out.println("calling next patient: " + next.getFirstName() + " " + next.getLastName());
                            queue.remove();
                        } else {
                            System.out.println("no patients to call in");
                        }
                        break;
                    case 6:
                        System.out.println(queue);
                        break;
                    case 7:
                        saveData(patients);
                        flag = true;
                        break;
                    default:
                        System.out.println("invalid command");
                        break;
                }
            } else {
                String invalidInput = sc.nextLine();
                System.out.println("Invalid input: " + invalidInput);
            }

        }
    }

    /**
     * save data to binary file
     *
     * @param patients the hashmap of patients
     * @throws IOException if something went wrong
     */
    public static void saveData(HashMap patients) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.bin"));
        out.writeObject(patients);
        out.close();
    }

    /**
     * display menu
     */
    public static void menu() {
        System.out.println("Hospital menu-------------:");
        System.out.println("1. Add a new patient");
        System.out.println("2. Delete a patient");
        System.out.println("3. Display all patients");
        System.out.println("4. Create a new appointment");
        System.out.println("5. Call the next patient");
        System.out.println("6. Display appointment queue");
        System.out.println("7. Exit");
        System.out.println("Choose an option:");
    }

    /**
     * add a patient to the hashmap
     *
     * @param patients the hashmap of patients
     * @return true or false, if added or not
     */
    private static boolean addPatient(HashMap patients) {
        LocalDate dob;
        LocalDate join;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter patient details:");
        System.out.print("First name: ");
        String firstName = sc.nextLine();
        System.out.print("Last name: ");
        String lastName = sc.nextLine();

        try {
            System.out.print("Date of birth (YYYY-MM-DD): ");
            dob = LocalDate.parse(sc.nextLine());
            System.out.println("enter join date (YYYY-MM-DD): ");
            join = LocalDate.parse(sc.nextLine());
        } catch (DateTimeParseException e) {
            System.out.println("invalid dates");
            return false;
        }
        Patient patient = new Patient(firstName, lastName, dob, join);
        patients.put(firstName, patient);
        return true;
    }

    /**
     * remove a patient from the hashmap
     *
     * @param patients the hashmap of patients
     * @return true or false, if added or not
     */
    public static boolean deletePatient(HashMap patients) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the patients first name: ");
        String firstName = sc.nextLine();

        if (patients.containsKey(firstName)) {
            patients.remove(firstName);
            return true;
        } else {
            return false;
        }
    }

    /**
     * add a new appointment to the queue, patient is found in queue
     *
     * @param patients the hashmap of patients
     * @param queue the queue of appointments
     * @return true or false, if added or not
     */
    public static boolean newAppointment(HashMap patients, PriorityQueue queue) {
        Scanner sc = new Scanner(System.in);
        Random rg = new Random();

        System.out.println("enter the patient first name: ");
        String firstName = sc.nextLine();

        Patient patient = patients.get(firstName);
        if (patient != null) {
            System.out.println("what is the issue: ");
            String issue = sc.nextLine();
            System.out.println("enter doctor name: ");
            String doctor = sc.nextLine();

            Appointment appointment = new Appointment(rg.nextInt(1, 6),
                    patient.getFirstName(), patient.getLastName(),
                    patient.getBirthDate(), issue, patient.getJoinDate(), doctor);
            queue.add(appointment);
            patients.get(firstName).getAppointments().add(appointment);
            return true;
        } else {
            return false;
        }
    }

}
