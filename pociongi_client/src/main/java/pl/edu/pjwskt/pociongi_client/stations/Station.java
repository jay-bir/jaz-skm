package pl.edu.pjwskt.pociongi_client.stations;

import pl.edu.pjwskt.pociongi_client.trains.Train;

import java.util.ArrayList;
import java.util.Random;

public class Station {
    private String name;
    private ArrayList<Passenger> passengers;
    private Train trainForward;
    private Train trainBackward;

    public Station(String name){
        passengers = new ArrayList<>();
        this.name = name;
    }

    public Station(){

    }



    public String getName(){
        return this.name;
    }

    public ArrayList<Passenger> getPassengers(){
        return this.passengers;
    }

    public void generatePassengers(String[] destinations){
        Random random = new Random();
        int nrOfPassengers = random.nextInt(6) + 2;
        for(int i = 0; i < nrOfPassengers; i++){
            passengers.add(i,new Passenger(destinations));
        }
    }
}
