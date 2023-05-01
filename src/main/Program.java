package main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import util.HashMap;
import util.Patient;
import util.PriorityQueue;

public class Program {

    public static void main(String[] args) {
        HashMap patients = new HashMap();
        PriorityQueue queue = new PriorityQueue();
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean flag = false;


        while(!flag){
            menu();
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    if(addPatient(patients)){
                        System.out.println("patient added successfully!");
                    }
                    else{
                        System.out.println("patient failed to be added");
                    }
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println(patients);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    flag = true;
                    break;
                default:
                    System.out.println("invalid command");
                    break;
            }
        }

    }

    public static void menu(){
        System.out.println("Hospital menu-------------:");
        System.out.println("1. Add a new patient");
        System.out.println("2. Delete a patient");
        System.out.println("3. Display all patients");
        System.out.println("4. Create a new appointment");
        System.out.println("5. Call the next patient");
        System.out.println("6. Exit");
        System.out.println("Choose an option:");
    }
    
     private static boolean addPatient(HashMap patients) {
         LocalDate dob;
         LocalDate join;
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter patient details:");
         System.out.print("First name: ");
         String firstName = sc.nextLine();
         System.out.print("Last name: ");
         String lastName = sc.nextLine();

         try{
             System.out.print("Date of birth (YYYY-MM-DD): ");
             dob = LocalDate.parse(sc.nextLine());
             System.out.println("enter join date (YYYY-MM-DD): ");
             join = LocalDate.parse(sc.nextLine());
         }
         catch(DateTimeParseException e){
             System.out.println("invalid dates");
             return false;
         }

         Patient patient = new Patient(firstName, lastName, dob, join);
         patients.put(firstName, patient);
         return true;
     }
     
     
     
}
