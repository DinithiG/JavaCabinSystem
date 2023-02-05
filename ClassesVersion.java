package ClassesPart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClassesVersion {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
        Cabin[] cruise = new Cabin[12];
        cruise[0] = new Cabin();
        cruise[1] = new Cabin();
        cruise[2] = new Cabin();
        cruise[3] = new Cabin();
        cruise[4] = new Cabin();
        cruise[5] = new Cabin();
        cruise[6] = new Cabin();
        cruise[7] = new Cabin();
        cruise[8] = new Cabin();
        cruise[9] = new Cabin();
        cruise[10] = new Cabin();
        cruise[11] = new Cabin();

        boolean process = true; //boolean value to control the while loop
        initialise(cruise); //initialising starting values

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
                    "\nEnter 'T' to print the expenses per passenger and the total expenses of all passengers "+
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
               case "T" -> totalExpenses(cruise);
               case "X" -> process = false; // programme stops
              default -> System.out.println("Wrong input entered");
           }
        }
    }

    private static void initialise(Cabin[] cruise) {
        for (Cabin cabin : cruise) {
            cabin.setName("e");cabin.setName2("e");cabin.setName3("e"); // avoid crashing
            cabin.setFirstPsgExpenses(0); cabin.setSecondPsgExpenses(0);cabin.setThirdPsgExpenses(0); // to avoid crashing when it's null
            cabin.setNoPsg(0);
            cabin.setFirstPsgSurname("e");cabin.setSecondPsgSurname("e");cabin.setThirdPsgSurname("e");
        }
        System.out.println("code is initialized");
    }

    static Passenger queue = new Passenger(36); // array to store customers in the waiting list

    private static void addCustomers(Cabin[] cruise) {
        boolean capacity = true;
        for (Cabin cabin : cruise) {
            if (cabin.getNoPsg() == 0 ) {
                capacity = false;}
        else {capacity = true;}}
        try {
            if (capacity == false) {  // when all cabins are not occupied
                System.out.println("Enter room number from (0-11) : ");
                int cabinNumber = input.nextInt();
                if (cabinNumber >= 0 && cabinNumber <= 11) {
                    System.out.println("Enter the number of passengers (maximum should be 3) : ");
                    int noPsg = input.nextInt();
                    if (noPsg>=1 && noPsg <= 3) {
                        if (cruise[cabinNumber].getName().equals("e")) {
                            cruise[cabinNumber].setNoPsg(noPsg);
                            if (cruise[cabinNumber].getNoPsg() == 1) {
                                System.out.println("Enter your first name  to book cabin " + cabinNumber + " : ");
                                String firstname = input.next();
                                cruise[cabinNumber].setName(firstname.toLowerCase());
                                System.out.println("Enter your surname to book cabin " + cabinNumber + " : ");
                                cruise[cabinNumber].setFirstPsgSurname(input.next().toLowerCase());
                                System.out.println("Enter your total expenses : ");
                                cruise[cabinNumber].setFirstPsgExpenses(input.nextInt());
                                cruise[cabinNumber].setTotal(cruise[cabinNumber].getFirstPsgExpenses());
                            } else {
                                System.out.println("Enter the first name of passenger 1 to book cabin " + cabinNumber + " : ");
                                String firstname = input.next();
                                cruise[cabinNumber].setName(firstname.toLowerCase());
                                System.out.println("Enter the  surname  of passenger 1 to book cabin " + cabinNumber + " : ");
                                cruise[cabinNumber].setFirstPsgSurname(input.next().toLowerCase());
                                System.out.println("Enter the total expenses of passenger 1 : ");
                                cruise[cabinNumber].setFirstPsgExpenses(input.nextInt());
                                if (noPsg >= 2) {
                                    System.out.println("Enter the first name of passenger 2 to book cabin " + cabinNumber + " : ");
                                    String firstname2 = input.next();
                                    cruise[cabinNumber].setName2(firstname2.toLowerCase());
                                    System.out.println("Enter the  surname  of passenger 2 to book cabin " + cabinNumber + " : ");
                                    cruise[cabinNumber].setSecondPsgSurname(input.next().toLowerCase());
                                    System.out.println("Enter the total expenses of passenger 2 : ");
                                    cruise[cabinNumber].setSecondPsgExpenses(input.nextInt());
                                    cruise[cabinNumber].setTotal(cruise[cabinNumber].getFirstPsgExpenses() + cruise[cabinNumber].getSecondPsgExpenses());
                                }
                                if (noPsg == 3) {
                                    System.out.println("Enter the first name of passenger 3 to book cabin " + cabinNumber + " : ");
                                    String firstname3 = input.next();
                                    cruise[cabinNumber].setName3(firstname3.toLowerCase());
                                    System.out.println("Enter the  surname  of passenger 3 to book cabin " + cabinNumber + " : ");
                                    cruise[cabinNumber].setThirdPsgSurname(input.next().toLowerCase());
                                    System.out.println("Enter the total expenses of passenger 3 : ");
                                    cruise[cabinNumber].setThirdPsgExpenses(input.nextInt());
                                    cruise[cabinNumber].setTotal(cruise[cabinNumber].getFirstPsgExpenses() + cruise[cabinNumber].getSecondPsgExpenses() +
                                            cruise[cabinNumber].getThirdPsgExpenses());
                                }
                            }
                            System.out.println("Cabin reserved successfully !");
                        } else {
                            System.out.println("Cabin " + cabinNumber + " is already occupied ");
                            System.out.println("Use the cabin menu to view empty rooms");
                        }
                    } else {
                        System.out.println("Wrong passenger amount entered try again "); //if passenger amount is not between 1-3
                    }

                } else {
                    System.out.println("Wrong cabin number entered.Try again!");
                }
            }
            else{
                System.out.println("All cabins are occupied");
                System.out.println("please enter your first name : ");
                queue.enQueue(input.next().toLowerCase());
                System.out.println("please enter your surname : ");
                queue.enQueue(input.next().toLowerCase());
                System.out.println("You will be added to a waiting list");
                //passenger name is added to the waiting list
                }

        }
        catch (InputMismatchException e){
            System.out.println("Wrong input data type entered .Try again");
            input.next();
        }
    }



    private static void viewCustomers(Cabin[] cruise) {
        System.out.println("Empty cabins are displayed using e");
        for (int x = 0; x < 12; x++) {
            if (cruise[x].getNoPsg() == 0) {
                System.out.println("Cabin " +x+ " is e");}
            else {
                if(cruise[x].getNoPsg() == 1) {
                    System.out.println("Cabin " + x + " is occupied by " + cruise[x].getName()+" "+cruise[x].getFirstPsgSurname());}
                else if(cruise[x].getNoPsg() == 2) {
                    System.out.println("Cabin " + x + " is occupied by " + cruise[x].getName()+" "+cruise[x].getFirstPsgSurname()+ " and "+ cruise[x].getName2()+" "+cruise[x].getSecondPsgSurname());}
                else {
                    System.out.println("Cabin " + x + " is occupied by " + cruise[x].getName()+" "+cruise[x].getFirstPsgSurname()+ " , "+ cruise[x].getName2()+" "+cruise[x].getSecondPsgSurname()+" and " +cruise[x].getName3()+" "+cruise[x].getThirdPsgSurname());}
            }
        } //shows empty cabins and not empty cabins
    }

    private static void emptyCabins(Cabin[] cruise) {
        int var = 0;
        for (int x = 0; x < 12; x++) {
            if (cruise[x].getName().equals("e")) {
                System.out.println("Cabin " + x + " is empty");
                var++;
            }
        }
        if(var == 0){
            System.out.println("All cabins are occupied"); //to let the customer know if all cabins are occupied
        }
    }

    private static void deleteCustomers(Cabin[] cruise) {
        System.out.println("Enter the number of the room you want to delete passenger from : ");
        int cabinNumber = input.nextInt();
        if (cabinNumber>=0 && cabinNumber<=11){
        if (cruise[cabinNumber].getNoPsg() == 0) {
            System.out.println("Cabin is an empty cabin");
        }
        if (cruise[cabinNumber].getNoPsg() == 1) {
            cruise[cabinNumber].setName("e");
            cruise[cabinNumber].setNoPsg(0);
            System.out.println("Successfully deleted customer from cabin " + cabinNumber);
            cruise[cabinNumber].setName(queue.deQueue()); //first customer in the waiting list is added to the deleted cabin
            cruise[cabinNumber].setNoPsg(1); // to make the view function work
            cruise[cabinNumber].setFirstPsgSurname(queue.deQueue());  //first surname in the waiting list is added
            cruise[cabinNumber].setFirstPsgExpenses(0);
            cruise[cabinNumber].setTotal(0); // to make adding to file easier

        } else {
            System.out.println("Enter the first  name of customer to delete from cabin " + cabinNumber + " :");
            String name = input.next();
            name = name.toLowerCase();
            if (name.equals(cruise[cabinNumber].getName())) {
                cruise[cabinNumber].setName(cruise[cabinNumber].getName2());
                cruise[cabinNumber].setFirstPsgExpenses(cruise[cabinNumber].getSecondPsgExpenses());
                cruise[cabinNumber].setName2(cruise[cabinNumber].getName3());
                cruise[cabinNumber].setSecondPsgExpenses(cruise[cabinNumber].getThirdPsgExpenses());
                cruise[cabinNumber].setNoPsg(cruise[cabinNumber].getNoPsg() - 1);
                cruise[cabinNumber].setName3("e");
                cruise[cabinNumber].setThirdPsgExpenses(0);
                System.out.println("Successfully deleted " + name + " from cabin " + cabinNumber);
            } else if (name.equals(cruise[cabinNumber].getName2())) {
                cruise[cabinNumber].setName2(cruise[cabinNumber].getName3());
                cruise[cabinNumber].setSecondPsgExpenses(cruise[cabinNumber].getThirdPsgExpenses());
                cruise[cabinNumber].setName3("e");
                cruise[cabinNumber].setThirdPsgExpenses(0);
                cruise[cabinNumber].setNoPsg(cruise[cabinNumber].getNoPsg() - 1);
                System.out.println("Successfully deleted " + name + " from cabin " + cabinNumber);
            } else if (name.equals(cruise[cabinNumber].getName3())) {
                cruise[cabinNumber].setName3("e");
                cruise[cabinNumber].setThirdPsgExpenses(0);
                cruise[cabinNumber].setNoPsg(cruise[cabinNumber].getNoPsg() - 1);
                System.out.println("Successfully deleted " + name + " from cabin " + cabinNumber);
            } else {
                System.out.println("Wrong first name entered");
            }
        }
    }
        else{
            System.out.println("Wrong cabin number entered.Try again!");
        }
    }

    private static void findByName(Cabin[] cruise) {
        System.out.println("Enter the first name of the customer you want to find : ");
        String findName = input.next();
        findName = findName.toLowerCase();
        int var =0;
        for (int x = 0; x < 12; x++) { //to check which cabin is the passenger in
            if (findName.equals(cruise[x].getName())) {
                System.out.println("cabin " + x + " is occupied by " + findName);var++;}
            if (findName.equals(cruise[x].getName2())) {
                System.out.println("cabin " + x + " is occupied by " + findName);var++;}
            if (findName.equals(cruise[x].getName3())) {
                System.out.println("cabin " + x + " is occupied by " + findName);var++;}
        }
        if(var==0){
            System.out.println("Wrong name entered.Check again"); //when user entered a wrong name
        }
    }

    private static void storeDataInFile(Cabin[] cruise) {
        try{
            File file = new File("CabinData.txt");
            FileWriter writeInput = new FileWriter("CabinData.txt");
            for (int x = 0; x < 12; x++ ){
                if(cruise[x].getNoPsg() == 1) {
                    writeInput.write("cabin " + x + " is occupied by " + cruise[x].getName()+" "+cruise[x].getFirstPsgSurname()+"\n Total expenses for  cabin "+x+" is "+cruise[x].getTotal()+"\n");}
                else if(cruise[x].getNoPsg() == 2) {
                    writeInput.write("cabin " + x + " is occupied by " + cruise[x].getName()+" "+cruise[x].getFirstPsgSurname()+ " and "+ cruise[x].getName2()+" "+cruise[x].getSecondPsgSurname()+"\nTotal expenses for  cabin "+x+" is "+cruise[x].getTotal()+"\n");}
                else if(cruise[x].getNoPsg() == 3)  {
                    writeInput.write("cabin " + x + " is occupied by " + cruise[x].getName()+" "+cruise[x].getFirstPsgSurname()+ " , "+ cruise[x].getName2()+" "+cruise[x].getSecondPsgSurname()+" and " +cruise[x].getName3()+" "+cruise[x].getThirdPsgSurname()+"\nTotal expenses for  cabin "+x+" is "+cruise[x].getTotal()+"\n");}
                else{writeInput.write("cabin " + x + " is empty\n");}
            }
            writeInput.close();
            System.out.println("Cabin data is successfully stored in a text file");
        }
        catch (IOException e){
            System.out.println("An error occurred.");
        }
    }
    private static void loadFromFile(Cabin[] cruise) {
        try {
            File file = new File("CabinData.txt");
            FileWriter writeInput = new FileWriter("CabinData.txt");
            for (int x = 0; x < 12; x++ ){
                if(cruise[x].getNoPsg() == 1) {
                    writeInput.write("cabin " + x + " is occupied by " + cruise[x].getName()+" "+cruise[x].getFirstPsgSurname()+"\n Total expenses for  cabin "+x+" is "+cruise[x].getTotal()+"\n");}
                else if(cruise[x].getNoPsg() == 2) {
                    writeInput.write("cabin " + x + " is occupied by " + cruise[x].getName()+" "+cruise[x].getFirstPsgSurname()+ " and "+ cruise[x].getName2()+" "+cruise[x].getSecondPsgSurname()+"\nTotal expenses for  cabin "+x+" is "+cruise[x].getTotal()+"\n");}
                else if(cruise[x].getNoPsg() == 3)  {
                    writeInput.write("cabin " + x + " is occupied by " + cruise[x].getName()+" "+cruise[x].getFirstPsgSurname()+ " , "+ cruise[x].getName2()+" "+cruise[x].getSecondPsgSurname()+" and " +cruise[x].getName3()+" "+cruise[x].getThirdPsgSurname()+"\nTotal expenses for  cabin "+x+" is "+cruise[x].getTotal()+"\n");}
                else{writeInput.write("cabin " + x + " is empty\n");}
            }
            writeInput.close();
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);}}
        catch (IOException e){
            System.out.println("An error occurred.");}
    }

    private static void sortCustomerNames(Cabin[] cruise) {

        String[] name = {cruise[0].getName(),cruise[0].getName2(),cruise[0].getName3(),cruise[1].getName(),cruise[1].getName2()
                ,cruise[1].getName3(),cruise[2].getName(),cruise[2].getName2(),cruise[2].getName3(),cruise[3].getName(),
                cruise[3].getName2(),cruise[3].getName3(),cruise[4].getName(),cruise[4].getName2(),cruise[4].getName3(),
                cruise[5].getName(),cruise[5].getName2(),cruise[5].getName3(),cruise[6].getName(),cruise[6].getName2()
                ,cruise[6].getName3(),cruise[7].getName(),cruise[7].getName2(),cruise[7].getName3(),cruise[8].getName(),
                cruise[8].getName2(),cruise[8].getName3(), cruise[9].getName(),cruise[9].getName2(),cruise[9].getName3(),
                cruise[10].getName(),cruise[10].getName2(),cruise[10].getName3(),cruise[11].getName(),cruise[11].getName2(),
                cruise[11].getName3()}; // storing all names in array to sort , even empty "e" cabins are stored

        String store;
        System.out.println("Alphabetically sorted customer names : ");
        for (int j = 0; j < name.length; j++) {
            for (int i = j + 1; i < name.length; i++) {
                // comparing strings
                if (name[i].compareTo(name[j]) < 0) {
                    store = name[j];
                    name[j] = name[i];
                    name[i] = store;
                }
            }
            if (name[j] != "e"){
                System.out.println(name[j]); //to exclude empty "e" cabins from the sorted list
            }
        }
    }

    private static void totalExpenses(Cabin[] cruise) {
        System.out.println("Enter  cabin number to calculate the total expenses : ");
        int cabinNumber = input.nextInt();
        if(cruise[cabinNumber].getNoPsg() >= 0){ //to make sure it's an occupied cabin
            if(cruise[cabinNumber].getNoPsg() ==1 ){
                System.out.println("Total expenses for  cabin "+cabinNumber+" is "+cruise[cabinNumber].getTotal());}
                // get total method adds all the expenses together
            else if(cruise[cabinNumber].getNoPsg() ==2 ){
                System.out.println("Total expenses for "+cruise[cabinNumber].getName()+" "+cruise[cabinNumber].getFirstPsgSurname()+" is "+cruise[cabinNumber].getFirstPsgExpenses());
                System.out.println("Total expenses for "+cruise[cabinNumber].getName2()+" "+cruise[cabinNumber].getSecondPsgSurname()+" is "+cruise[cabinNumber].getSecondPsgExpenses());
                System.out.println("Total expenses for  cabin "+cabinNumber+" is "+cruise[cabinNumber].getTotal());}
            else{
                System.out.println("Total expenses for "+cruise[cabinNumber].getName()+" "+cruise[cabinNumber].getFirstPsgSurname()+" is "+cruise[cabinNumber].getFirstPsgExpenses());
                System.out.println("Total expenses for "+cruise[cabinNumber].getName2()+" "+cruise[cabinNumber].getSecondPsgSurname()+" is "+cruise[cabinNumber].getSecondPsgExpenses());
                System.out.println("Total expenses for "+cruise[cabinNumber].getName3()+" "+cruise[cabinNumber].getThirdPsgSurname()+" is "+cruise[cabinNumber].getThirdPsgExpenses());
                System.out.println("Total expenses for  cabin "+cabinNumber+" is "+cruise[cabinNumber].getTotal());}
        }
        else{System.out.println("Cabin "+cabinNumber+ " is empty");} //just in case user enters a wrong input
    }
}
