/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignmentq1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class AssignmentQ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
 Scanner scanner = new Scanner(System.in);
        int maxStudents = 100; 
        Student[] students = new Student[maxStudents];
        int studentCount = 0;
         //The main menu for the program
        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("***********************************");
            System.out.println("Please may you select one of the menu items: ");
            System.out.println("(1) Enter a new student");
            System.out.println("(2) Search for a student");
            System.out.println("(3) Delete a student");
            System.out.println("(4) Print a student");
            System.out.println("(5) Exit application");
             int choice = scanner.nextInt();
            scanner.nextLine(); // 
            //not more than 100 students
            switch (choice) {
                case 1:
                    if (studentCount < maxStudents) {
                        SaveStudent(scanner, students, studentCount);
                        studentCount++;
                        } else {
                        System.out.println("Maximum number of students have been added.");
                    }
                    break;
                case 2:
                    SearchStudent(scanner, students, studentCount);
                    break;
                case 3:
                    DeleteStudent(scanner, students, studentCount);
                    break;
                case 4:
                    StudentReport(students, studentCount);
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                     System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    // This method is used to capture the information of the students
    public static void SaveStudent(Scanner scanner, Student[] students, int studentCount) {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("*************************");
        System.out.println("enter the student id:");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("enter the student name:");
        String studentName = scanner.nextLine();

        int studentAge = getValidStudentAge(scanner);

        System.out.println("enter the student email:");
        String studentEmail = scanner.nextLine();

        System.out.println("enter the student course:");
        String studentCourse = scanner.nextLine();

        students[studentCount] = new Student(studentID, studentName, studentAge, studentEmail, studentCourse);
        System.out.println("Student details successfully saved.");
    }
    //This method is used to get the age of the students, age must be less than 16
     public static int getValidStudentAge(Scanner scanner) {
        int studentAge = -1;
        boolean validAge = false;

        while (!validAge) {
            System.out.println("enter the student age:");
            try {
                studentAge = scanner.nextInt();
                scanner.nextLine(); 
                if (studentAge >= 16) {
                    validAge = true;
                 } else {
                    System.out.println("you have entered an incorrect student age!!!");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); 
                System.out.println("Please re-enter the student age");
            }
        }

        return studentAge;
    
 }
 //This method is used to search for the students
  public static void SearchStudent(Scanner scanner, Student[] students, int studentCount) {
        System.out.println("Enter student id to search: ");
        int searchID = scanner.nextInt();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID() == searchID) {
                System.out.println("Student Found:");
                System.out.println("ID: " + students[i].getStudentID());
                System.out.println("Name: " + students[i].getStudentName());
                System.out.println("Age: " + students[i].getStudentAge());
                System.out.println("Email: " + students[i].getStudentEmail());
                System.out.println("Course: " + students[i].getStudentCourse());
                return;
}
            
        }
        
        System.out.println("Student with student id" + searchID +" was not found!!");
  }
  //this method is used to delete students
       public static void DeleteStudent(Scanner scanner, Student[] students, int studentCount) {
        System.out.println("enter the student id to delete: ");
        int deleteID = scanner.nextInt();
        System.out.println("are you sure you want to delete " + deleteID + " from the system ? Yes (y) to delete");

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID() == deleteID) {
                
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null; // Set the last element to null
                System.out.println("Student deleted successfully.");
                studentCount--;
                return;
}
        }
        System.out.println("Student not found.");
  }
  //this method is used to print all the reports of the students
  public static void StudentReport(Student[] students, int studentCount) {
        System.out.println("Student Report:");
        System.out.println("-----------------------------------");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("ID: " + students[i].getStudentID());
            System.out.println("Name: " + students[i].getStudentName());
            System.out.println("Age: " + students[i].getStudentAge());
            System.out.println("Email: " + students[i].getStudentEmail());
            System.out.println("Course: " + students[i].getStudentCourse());
            System.out.println();
            System.out.println("----------------------------------");
        } 
    }
    
}
/*
Sources
https://www.geeksforgeeks.org/loops-in-java/
https://www.javatpoint.com/java-for-loop
https://www.simplilearn.com/tutorials/java-tutorial/arrays-in-java
*/

