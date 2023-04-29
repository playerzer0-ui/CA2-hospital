package main;

import java.time.LocalDate;
import java.util.Queue;
import java.util.Scanner;
import util.HashMap;
import util.Patient;

public class Program {
    
    private static HashMap patients = new HashMap();
    private static Queue appointments = new Queue();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Add a new patient");
            System.out.println("2. Delete a patient");
            System.out.println("3. Display all patients");
            System.out.println("4. Create a new appointment");
            System.out.println("5. Call the next patient");
            System.out.println("6. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    deletePatient(scanner);
                    break;
                case 3:
                    displayPatients();
                    break;
                case 4:
                    createAppointment(scanner);
                    break;
                case 5:
                    callNextPatient();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

            System.out.println();

        } while (choice != 6);

        scanner.close();
    }
    
    
     private static void addPatient(Scanner scanner) {
        System.out.println("Enter patient details:");
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Date of birth (DD/MM/YYYY): ");
        LocalDate dob = scanner.next();

        Patient patient = new Patient(firstName, lastName, dob);

    }
     
     
     
}
