package eurostar.program.coursework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class EurostarProgramCoursework {

    static ArrayList<String> waitingRoom = new ArrayList<>();
        static ArrayList<String> trainQueue = new ArrayList<>();

    public static void main(String[] args) {

        try {
            File list = new File("passengers.dat"); //reads and loads file
            Scanner myReader = new Scanner(list);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                waitingRoom.add(data); //places loaded file into array list
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        
        menu();
    }
        
    public static void menu(){

        System.out.println("              Hello                 \n"
                + "     Welcome to the Eurostar\n"
                + "#####################################\n");

        System.out.println("Please select one of the following options\n"
                + "A : Add passenger to train queue\n"
                + "V : View train queue\n"
                + "D : Delete passenger from train queue\nS : Store train queue data\n"
                + "L : Load data into train queue\nR : Run simulation and produce report\n"
                + "Q : Quit ");

        Scanner input = new Scanner(System.in);
        System.out.println("What option would you like to select : ");
        String input_menu = input.next();
        System.out.println("\n");

        switch (input_menu) {
            case "a":
            case "A":
                trainQueue_add();
                break;
            case "v":
            case "V":
                trainQueue_view();
                break;
            case "d":
            case "D":
                // trainQueue_delete();
                break;
            case "q":
            case "Q":
                System.exit(0);
            case "s":
            case "S":
                trainQueue_save();
                break;
            case "l":
            case "L":
                trainQueue_load();
                break;
            case "r":
            case "R":
                if(waitingRoom.isEmpty()){
                    System.out.println("There are no passengers to run the simulation\n");
                    menu();
                }
                passengerQueue run = new passengerQueue();
                run.run_simulation();
                break;
            default:
                System.out.println("Sorry that is an incorrect input\n");
                menu();
        }//switch case that detects input correction from input errors, will loop back

    }

    public static void trainQueue_add() {
                    
        
        Scanner inputFirst = new Scanner(System.in);
        
        System.out.println("Please enter your first name :"); //importing scanner input for name
        String firstname_input = inputFirst.next();
        String firstname_capital = firstname_input.substring(0, 1).toUpperCase() + firstname_input.substring(1);
        
        System.out.println("\n");
        
        Scanner inputSecond = new Scanner(System.in);
        System.out.println("Please enter your surname :");
        String surname_input = inputSecond.next();
        String surname_capital = surname_input.substring(0, 1).toUpperCase() + surname_input.substring(1);

        System.out.println("\n");
        
        String fullname = firstname_capital + " " + surname_capital;
        System.out.println("Please be seated " + fullname);
        
        waitingRoom.add(fullname);
        System.out.println("\n");
        
        menu();
        
    }
    
    public static void trainQueue_view(){
        System.out.println("    Passengers - Waiting Room"
                + "\n///////////////////////////////////");
        for(String i : waitingRoom){
            System.out.println(i);
        }
        System.out.println("\n");
        
        menu();
    }
    
    public static void trainQueue_save(){
         try {
            FileWriter list = new FileWriter("passengers new queue.dat"); //writes a new file
            for (String str : waitingRoom) {
                list.write(str + System.lineSeparator());
            } //adds the array list into file and seperates
            list.close();
             System.out.println("Passengers Saved ---\n");
        } catch (IOException e) { //catches if save is a failure
            System.out.println("An error occurred.");
        }
         menu();
    }
    
    public static void trainQueue_load(){
        waitingRoom.clear(); //empites pre exisiting seats to it doesnt print twice
        try {
            File list = new File("passengers new queue.dat"); //reads and loads file
            Scanner myReader = new Scanner(list);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                waitingRoom.add(data); //places loaded file into array list
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        
        menu();
    }

}
