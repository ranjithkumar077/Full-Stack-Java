package LSM;

import java.util.ArrayList;
import java.util.Scanner;

public class  LibraryManagementSystem{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        static  ArrayList<Users> usersList = new ArrayList<>();
       try{ System.out.println("==========================|--__  Welcome to the Library Management System __--|==========================");
        // You can add code here to initialize and run the library management system
     
  
        Menu();
      int choice;
     
      System.out.print("Enter your choice: ");
      choice=sc.nextInt();
      System.out.println("Choice is : "+choice);
      sc.close();}
    catch (Exception e) {
        // TODO: handle exception
        System.out.println("Invalid Input. Please enter a valid choice.");
        System.out.println("error: "+e.getMessage());
    }
        switch(choice){
            case 1:
            System.out.println("You have chosen to Register/Signup");
            break;
            case 2:
            System.out.println("You have chosen to Login");
            break;
            // In handleAdminChoice() and handleStudentChoice()
            case 3:
            System.out.print("Are you sure? (y/n): ");
            if(sc.nextLine().toLowerCase().startsWith("y")) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
            break;

            default:
            System.out.println("Invalid Choice");
        }
    }
    public static void Menu(){
        System.out.println("The Library Management System has list of the functionalities:\n");
        System.out.println("1. Register/Signup");
        System.out.println("2. Login");
        System.out.println("3. Exit" );

    }
    public void coreFunctionality(int choice){
        switch (choice) {
            case 1:
                Register();
                break;
                case 2:
                Login();
        
            default:
                break;
        }

        // System.out.println("Core Functionalities of Library Management System are:\n");
        // System.out.println("1. Add Books");
        // System.out.println("2. Remove Books");
        // System.out.println("3. Search Books");
        // System.out.println("4. Issue Books");
        // System.out.println("5. Return Books");
        // System.out.println("6. View Issued Books");
    }
    public void Register(){
        System.out.println("==============================================|   Register  |==============================================");
        System.out.println("Enter the City : ");
        String city=sc.nextLine();
        System.out.println("");
        String username=;
    }
}
