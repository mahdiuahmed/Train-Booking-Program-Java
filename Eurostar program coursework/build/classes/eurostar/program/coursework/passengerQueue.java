package eurostar.program.coursework;

import java.util.ArrayList;

public class passengerQueue {

    static int thrownDice;

    static ArrayList<Integer> timeTotal = new ArrayList<>();

    static ArrayList<String> passenger_list = new ArrayList<>();

    public static void run_simulation() {

        EurostarProgramCoursework selected_passengers = new EurostarProgramCoursework();
        Passenger queueTime = new Passenger();

        //for(int x = 0; x < selected_passengers.waitingRoom.size(); x++){
        int number_of_passengers = (int) (Math.random() * 6 + 1);

        thrownDice = number_of_passengers;

        System.out.println("             Train queue"
                + "\n////////////////////////////////////////\n");

        for (int i = 0; i < number_of_passengers; i++) {

            if (selected_passengers.waitingRoom.isEmpty()) {
                break;
            } else {

                //String passengerName = selected_passengers.waitingRoom.get(number_of_passengers);
                //System.out.println(passengerName);
                passenger_list.add(queueTime.getName());

                queueTime.displayPassengerAndTime();
                timeTotal.add(queueTime.timeTaken_individual);
                //timeTotal.add(queueTime.timeTaken_individual);

                selected_passengers.waitingRoom.remove(0);

            }
        }
        System.out.println("\n");

        //}
        System.out.println("\n");
        queueTime.average();
        queueTime.first_passenger();
        queueTime.last_passenger();
        queueTime.getLength();
        queueTime.maxStayInQueue();
        
        System.out.println("\n");

        passenger_list.clear();

        if (selected_passengers.waitingRoom.isEmpty()) {
            report();
        } else {
            EurostarProgramCoursework returnTo_menu = new EurostarProgramCoursework();
            System.out.println("\n");
            returnTo_menu.menu();

        }
    }

    public static void report() {
        float sum = 0;
         for (int i = 0; i < timeTotal.size(); i++){
            
              sum += timeTotal.get(i);
         }
         System.out.println("The average time taken for boarding for all "
                 + "passengers : " + sum / timeTotal.size() + " seconds");
    }
}
