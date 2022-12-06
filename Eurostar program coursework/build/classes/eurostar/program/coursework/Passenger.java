package eurostar.program.coursework;

import java.util.ArrayList;
import java.util.Collections;

public class Passenger {
    
    ArrayList<Integer> times = new ArrayList<>();

    String passenger_name;
    int timeTaken_individual;
    int average_timeTaken;
    int seconds_queue;
    
    EurostarProgramCoursework nameOf_passenger = new EurostarProgramCoursework();
    passengerQueue number = new passengerQueue();

    public int secondsInQueue() {

        getSeconds();
        
        return timeTaken_individual;
    }
  
    public int getSeconds(){
        int secondsNO  = (int)(Math.random()*60 + 1);
        
            times.add(secondsNO);
        

        timeTaken_individual = secondsNO;
        
        return timeTaken_individual;
    }
    
    public String getName(){
        
        //int passenger_number = number.thrownDice;
        passenger_name = nameOf_passenger.waitingRoom.get(0);
        
        return passenger_name;
    }
   
     public void displayPassengerAndTime() {
         
         System.out.println(getName() + " took " + secondsInQueue() + " seconds to board");
    }
     
     public void average(){
         float sum = 0;
         for (int i = 0; i < times.size(); i++){
            
              sum += times.get(i);
         }
         System.out.println("The average time taken for boarding is : " + sum / times.size() + " seconds");
     }
     
     public void first_passenger(){
         String first = number.passenger_list.get(0);
         System.out.println("The first passenger was " + first );
     }
     
     public void last_passenger(){
         String last = number.passenger_list.get(number.passenger_list.size() -1);
         System.out.println("The last passenger was " + last);
     }
     
     public void maxStayInQueue(){
         System.out.println("The longest time taken to board was " + Collections.max(times) + " seconds");
     }
     
     public void getLength(){
         System.out.println("The length of the queue was " + number.passenger_list.size());
         
     }
}
