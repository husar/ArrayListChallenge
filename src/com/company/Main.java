package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobile = new MobilePhone();

    public static void main(String[] args) {
	    boolean quit = false;
        printOptions();
	    while (!quit){
	        if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option){
                    case 0:
                        printOptions();
                        break;
                    case 1:
                        mobile.printContacts();
                        break;
                    case 2:
                        addNumber();
                        break;
                    case 3:
                        modifyContact();
                        break;
                    case 4:
                        removeContact();
                        break;
                    case 5:
                        findContact();
                        break;
                    case 6:
                        quit = true;
                        break;
                    default:
                        System.out.println("Please put a valid option");
                        printOptions();
                        break;
                }
            }
	        else {
                System.out.println("Please enther the valid number");
                scanner.nextLine();
            }
        }
    }

    public static void printOptions(){
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact in the list");
        System.out.println("\t 3 - To modify a contact in the list");
        System.out.println("\t 4 - To remove a contact from the list");
        System.out.println("\t 5 - To search for a contact in the list");
        System.out.println("\t 6 - To quit the application");
    }

    public static void findContact(){
        System.out.println("Please enther the name, or number which you want remove: ");
        if (scanner.hasNextInt()){
            int number = scanner.nextInt();
            scanner.nextLine();
            mobile.searchForContact(number);
        }else {
            String name = scanner.nextLine();
            mobile.searchForContact(name);
        }
    }

    public static void removeContact(){
        System.out.println("Please enther the name, or number which you want remove: ");
        if (scanner.hasNextInt()){
            int number = scanner.nextInt();
            scanner.nextLine();
            mobile.removeContact(number);
        }else {
            String name = scanner.nextLine();
            mobile.removeContact(name);
        }
    }

    public static void modifyContact(){
        System.out.println("Please enther the name of contact which you want modify: ");
        String oldName = scanner.nextLine();
        System.out.println("Enter the new name: ");
        String newName = scanner.nextLine();
        int number = enterTheValidNumber();
        mobile.modifyContact(oldName,newName,number);
    }

    public static void addNumber(){
        System.out.println("Please enter the name:");
        String name = scanner.nextLine();
       int number = enterTheValidNumber();
        mobile.storeContact(name,number);
        System.out.println("The contact was stored.");
    }

    private static int enterTheValidNumber(){
        boolean validNum = false;
        int number = -1;
        while (!validNum) {
            System.out.println("Please enter the pone number:");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                //scanner.nextLine();
                validNum = true;
            }
            else{
                System.out.println("Please enter the valid number");
            }
            scanner.nextLine();
        }
        return number;
    }
}
