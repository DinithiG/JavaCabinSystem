package ArraysPart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysVersion {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        int cabinNumber = 0;
        String[] cruise = new String[12];

        //boolean value to control the while loop
        boolean process = true;

        initialise(cruise);
        // menu (/n to print multiple lines)
        String option; // string variable to store user's choice
        while (process){
            System.out.println("Cabin Menu :" +
                    " \nEnter 'A' to add  customer to a cabin " +
                    "\nEnter 'V' to view all cabins" +
                    "\nEnter 'E' to display empty cabins " +
                    "\nEnter 'D' to delete customers from cabins " +
                    "\nEnter 'F' to find a cabin from customer name " +
                    "\nEnter 'S' store cabin data into a file " +
                    "\nEnter 'L'  load cabin data from a file" +
                    "\nEnter 'O' to view customer names alphabetically" +
                    "\nEnter 'X' to exit from the menu" +
                    "\nPlease select one of the options above : ");
            option = input.next();
            option = option.toUpperCase();
            switch (option) {
                case "A" -> addCustomers(cruise);
                case "V" -> viewCustomers(cruise);
                case "E" -> emptyCabins(cruise);
                case "D" -> deleteCustomers(cruise);
                case "F" -> findByName(cruise);
                case "S" -> storeDataInFile(cruise);
                case "L" -> loadFromFile(cruise);
                case "O" -> sortCustomerNames(cruise);
                case "X" -> process = false;
                default -> System.out.println("Wrong input entered");
            }
        }

    }

    private static void initialise(String[] cruiseRef)
    {
        for (int x = 0; x < 12; x++ ) cruiseRef[x] = "e";
        System.out.println( "code is initialised");
    }

    public static void addCustomers(String[] cruise){
        try {
            System.out.println("Enter room number from (0-11) : ");
            int cabinNumber = input.nextInt();
            if (cabinNumber>=0 && cabinNumber<=11){
            if (cruise[cabinNumber] == "e") {
                System.out.println("Enter your first name to book  cabin " + cabinNumber + " : ");
                String cabinName = input.next();
                cabinName = cabinName.toLowerCase();
                cruise[cabinNumber] = cabinName;
                System.out.println("Cabin "+cabinNumber+" is successfully booked!");
            } else {
                System.out.println("Cabin " + cabinNumber + " is already occupied.Please try the menu to view empty cabins");
            }
            }
            else{
                System.out.println("Wrong cabin number entered.Try again!");
            }
        }
        catch (InputMismatchException e){
            System.out.println("Wrong input data type entered .Try again");
            input.next();
        }
    }

    public static void viewCustomers(String[] cruise){
        System.out.println("Empty cabins are displayed using e");
        for (int x = 0; x < 12; x++ ){
            if (cruise[x] == "e") {
                System.out.println("Cabin "+x+" is e");
            } else { //if not empty
                System.out.println("Cabin " + x + " is occupied by " + cruise[x]);
            }

        }
    }

    public static void deleteCustomers(String[] cruise){
        System.out.println("Enter the number of the room you want to delete customer from : ");
        int cabinNumber = input.nextInt();
        if (cabinNumber>=0 && cabinNumber<=11){
        cruise[cabinNumber] = "e";} //make that cabin empty after deleting the customer from it
        else{
            System.out.println("Wrong cabin number entered.Try again!");
        }
    }

    public static void emptyCabins(String[] cruise) {
        int var = 0;
        for (int x = 0; x < 12; x++) {
            if (cruise[x].equals("e")) {
                System.out.println("cabin " + x + " is empty");
                var++;
            }
        }
        if(var == 0){
            System.out.println("All cabins are occupied"); //to let the customer know if all rooms are occupied
        }
    }

    public static void findByName(String[] cruise){
        System.out.println("Enter the name of the customer you want to find : ");
        String findName = input.next();
        findName = findName.toLowerCase();
        int var = 0;
        for (int x = 0; x < 12; x++) {
            if (cruise[x].equals(findName)) {
                System.out.println("cabin " + x + " is occupied by " + findName); //to check which cabin is the passenger in
                var++;
            }
        }
        if(var==0){
            System.out.println("Wrong name entered.Check again"); //when user entered a wrong name
        }

    }

    public static void storeDataInFile(String[] cruise){
        try{
            File file = new File("CabinData.txt"); //file CabinData is created
            FileWriter writeInput = new FileWriter("CabinData.txt");
            for (int x = 0; x < 12; x++ ){
                if(cruise[x].equals("e") ){
                    writeInput.write("cabin " + x + " is empty "+"\n");
                }
                else{
                writeInput.write("cabin " + x + " is occupied by "+ cruise[x]+"\n");}
            }
            writeInput.close();
            System.out.println("Cabin data is successfully stored in a text file");
        }
        catch (IOException e){
            System.out.println("An error occurred.");
        }

    }

    public static void loadFromFile(String[] cruise){
        try {
            File file = new File("CabinData.txt"); //file CabinData is created
            FileWriter writeInput = new FileWriter("CabinData.txt");
            for (int x = 0; x < 12; x++ ){
                if(cruise[x].equals("e") ){
                    writeInput.write("cabin " + x + " is empty "+"\n");
                }
                else{
                writeInput.write("cabin " + x + " is occupied by "+ cruise[x]+"\n");}
            }
            writeInput.close();
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
        }
        catch (IOException e){
            System.out.println("An error occurred.");
        }

    }

    public static void sortCustomerNames(String[] cruise) {
        String[] copiedCruise = cruise.clone(); // cloning the code to make sure original array is not altered
        String store;
        System.out.println("Alphabetically sorted customer names : ");
        for (int j = 0; j < 12; j++) {
            for (int i = j + 1; i < 12; i++) {
                // comparing strings
                if (copiedCruise[i].compareTo(copiedCruise[j]) < 0) {
                    store = copiedCruise[j];
                    copiedCruise[j] = copiedCruise[i];
                    copiedCruise[i] = store;
                }
            }
            if (copiedCruise[j]!= "e"){ //to exclude empty 'e' cabins from the sorted list
                System.out.println(copiedCruise[j]);
            }
        }
    }
}

