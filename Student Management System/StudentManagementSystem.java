import java.util.Arrays;
import java.util.Scanner;

class Student {
    String name;
    int roll;
    int marks;

    Student(String name, int roll, int marks) {
        this.name = name.trim();                 
        this.roll = Integer.valueOf(roll);     
        this.marks = marks;
    }

    void display() {
        System.out.println("Name  : " + name.toUpperCase()); 
        System.out.println("Roll  : " + roll);
        System.out.println("Marks : " + marks);
        System.out.println("----------------------");
    }
}

public class StudentManagementSystem {

    static Student[] students = new Student[0];  

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine()); 

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent(sc);
                    break;

                case 4:
                    deleteStudent(sc);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);  

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add 
    static void addStudent(Scanner sc) {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll: ");
        int roll = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Marks: ");
        int marks = Integer.parseInt(sc.nextLine());

        Student s = new Student(name, roll, marks);

        students = Arrays.copyOf(students, students.length + 1); 
        students[students.length - 1] = s;

        System.out.println("Student Added Successfully!");
    }

    // View
    static void viewStudents() {

        if (students.length == 0) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Update 
    static void updateStudent(Scanner sc) {

        System.out.print("Enter Roll to Update: ");
        int roll = Integer.parseInt(sc.nextLine());

        for (Student s : students) {
            if (s.roll == roll) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine().trim();   

                System.out.print("Enter New Marks: ");
                s.marks = Integer.parseInt(sc.nextLine());

                System.out.println("Student Updated!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Delete
    static void deleteStudent(Scanner sc) {

        System.out.print("Enter Roll to Delete: ");
        int roll = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < students.length; i++) {

            if (students[i].roll == roll) {

                for (int j = i; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                }

                students = Arrays.copyOf(students, students.length - 1);

                System.out.println("Student Deleted!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }
}