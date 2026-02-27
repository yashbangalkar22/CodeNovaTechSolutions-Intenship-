import java.io.*;
import java.util.*;

class LibraryManagement {

    static final String FILE_NAME = "library.txt";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());   

            switch (choice) {

                case 1:
                    addBook(sc);
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    updateStatus(sc, "ISSUED");
                    break;

                case 4:
                    updateStatus(sc, "AVAILABLE");
                    break;

                case 5:
                    searchBook(sc);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);   

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add 
    static void addBook(Scanner sc) {

        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);

            System.out.print("Enter Book ID: ");
            int id = Integer.valueOf(sc.nextLine());   

            System.out.print("Enter Book Name: ");
            String name = sc.nextLine().trim();        

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine().trim();

            fw.write(id + "," + name.toUpperCase() + "," + author.toUpperCase() + ",AVAILABLE\n");
            fw.close();

            System.out.println("Book Added Successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }

    // View 
    static void viewBooks() {

        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("No Books Found!");
                return;
            }

            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();
                String[] data = line.split(",");   

                System.out.println("----------------------------");
                System.out.println("ID     : " + data[0]);
                System.out.println("Name   : " + data[1]);
                System.out.println("Author : " + data[2]);
                System.out.println("Status : " + data[3]);
            }

            fileReader.close();

        } catch (Exception e) {
            System.out.println("Error reading file!");
        }
    }

    // Issue / Return 
    static void updateStatus(Scanner sc, String newStatus) {

        try {

            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No Books Found!");
                return;
            }

            System.out.print("Enter Book ID: ");
            String idInput = sc.nextLine().trim();

            Scanner fileReader = new Scanner(file);
            String content = "";

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();
                String[] data = line.split(",");

                if (data[0].equals(idInput)) {  
                    data[3] = newStatus;
                    line = String.join(",", data);  
                    System.out.println("Book Updated!");
                }

                content += line + "\n";
            }

            fileReader.close();

            FileWriter fw = new FileWriter(FILE_NAME);
            fw.write(content);
            fw.close();

        } catch (Exception e) {
            System.out.println("Error updating file!");
        }
    }

    // Search 
    static void searchBook(Scanner sc) {

        try {

            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No Books Found!");
                return;
            }

            System.out.print("Enter Book Name to Search: ");
            String search = sc.nextLine().trim().toUpperCase();

            Scanner fileReader = new Scanner(file);
            boolean found = false;

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();

                if (line.toUpperCase().contains(search)) {  
                    System.out.println("Found: " + line);
                    found = true;
                }
            }

            if (!found)
                System.out.println("Book Not Found!");

            fileReader.close();

        } catch (Exception e) {
            System.out.println("Error searching file!");
        }
    }
}