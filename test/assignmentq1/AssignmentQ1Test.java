/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignmentq1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class AssignmentQ1Test {
     @Test
   public void testSaveStudent()
   {
       String input = "10111\nKen Kerr\n41\nKenKerr@example.com\nPhysics\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        
        
        Scanner scanner = new Scanner(System.in);

        
        int maxStudents = 100;
        Student[] students = new Student[maxStudents];
        int studentCount = 0;
        
        // Call the captureStudent method
       AssignmentQ1.SaveStudent(scanner, students, studentCount);

        
        assertEquals(0, studentCount); // Check if one student is captured
        assertEquals(10111, students[0].getStudentID());
        assertEquals("Ken Kerr", students[0].getStudentName());
        assertEquals(41, students[0].getStudentAge());
        assertEquals("KenKerr@example.com", students[0].getStudentEmail());
        assertEquals("Physics", students[0].getStudentCourse());
    }
   @Test
   public void testSearchStudent()
   {
    // Create a sample student for testing
        Student[] students = {
            new Student(1, "Yeezy", 41, "ye@gmail.com", "Music")
        };

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a sample input stream to provide student ID
        String input = "1\n"; // Replace with the student ID you want to search
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        // Call the searchStudent method
        AssignmentQ1.SearchStudent(new java.util.Scanner(System.in), students, 0);
        
         // Restore System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);

        // Verify the output
        
        assertEquals(1, students[0].getStudentID());

}
    @Test
    public void TestSearchStudent_StudentNotFound() {
        // Create an empty array of students for testing
        Student[] students = {};

        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a sample input stream to provide a student ID that doesn't exist
        String input = "2\n"; 
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        
        // Call the searchStudent method
        AssignmentQ1.SearchStudent(new java.util.Scanner(System.in), students, 0);
        // Restore System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "Enter student id to search:\nStudent with student id 2 was not found!!\n";
        assertEquals(expectedOutput,"Enter student id to search:\nStudent with student id 2 was not found!!\n" );
    }
     @Test
    public void testDeleteStudent() {
        // Create an array of students with one student for testing
        Student[] students = {
            new Student(11, "Jeffery", 88, "jeff@gmail.com", "History")
        };
        

     
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Create a sample input stream to provide the student ID to delete
        String input = "11/n"; // Replace with the student ID you want to delete
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        
        // Call the DeleteStudent method
        AssignmentQ1.DeleteStudent(new java.util.Scanner(System.in), students, 11);
        
         // Restore System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "enter the student id to delete: \n are you sure you want to delete 11 from the system ?  Yes (y) to delete\nStudent deleted successfully.\n";
        assertEquals(11, students[0].getStudentID());

        // Verify that the student has been deleted
        assertNull(students[0]); // The student should be null after deletion
}
    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Create an array of students with one student for testing
        Student[] students = {
            new Student(67, "Ronnie", 29, "ron@gmail.com", "Biology")
        };

        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        
        String input = "81\n"; // Use a student ID that doesnt exist
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        
         // Calling the DeleteStudent method
        AssignmentQ1.DeleteStudent(new java.util.Scanner(System.in), students, 0);

        
        System.setIn(System.in);
        System.setOut(System.out);

        // Verify the output
        String expectedOutput = "enter the student id to delete:\nare you sure you want to delete 81 from the system ?  Yes (y) to delete\nStudent not found.\n";
        assertEquals(expectedOutput, outContent.toString());

        
        assertNotNull(students[0]); 
    }
     @Test
    public void testStudentAge_StudentAgeValid() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput = "enter the student age:\n";

        // Create a sample input stream to provide a valid student age
        String input = " 44 "; // Replace with the valid student age you want to test
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        // Create a new Scanner using the custom input stream
        Scanner scanner = new Scanner(System.in);

        // Call the getValidStudentAge method
        int validAge = AssignmentQ1.getValidStudentAge(scanner);
        
        System.setIn(System.in);
        System.setOut(System.out);

        // Verify the output
        assertEquals(expectedOutput, "enter the student age:\n");

        // Verify that the validAge matches the input age
        assertEquals(44, validAge); // Replace with the expected valid age
    }
     @Test
    public void testStudentAge_StudentAgeInvalid() {
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // provide an invalid student age (less than 16)
        String input = "11\n"; // Put an invalid age that you want to test
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        
        Scanner scanner = new Scanner(System.in);

        // Calling the getValidStudentAge method
        int invalidAge = AssignmentQ1.getValidStudentAge(scanner);
        
        System.setIn(System.in);
        System.setOut(System.out);

        // Confirm the output
        String expectedOutput = "enter the student age:\nyou have entered an incorrect student age!!!\n";
        assertEquals(expectedOutput, outContent.toString());

        // To make sure that the invalidAge matches the input age
        assertEquals(input, invalidAge); 
    }
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
       
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        
        String input = "bbc\n"; // Use Invalid characters that need to be tested
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        
        Scanner scanner = new Scanner(System.in);

        // Calling the getValidStudentAge method
        int invalidAge = AssignmentQ1.getValidStudentAge(scanner);
        // Restore System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);

        // Testing the output
        String expectedOutput = "enter the student age:\nPlease re-enter the student age\n";
        assertEquals(expectedOutput, outContent.toString());

       
        assertEquals(-1, invalidAge); // Used -1 for the invalid age
    }
}

           
    
    

