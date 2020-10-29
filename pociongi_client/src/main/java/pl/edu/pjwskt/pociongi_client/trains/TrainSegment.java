package pl.edu.pjwskt.pociongi_client.trains;

import pl.edu.pjwskt.pociongi_client.stations.Passenger;

import java.util.ArrayList;

public class TrainSegment {
    private int id;
    private int capacity;
    private float density;
    private ArrayList<Passenger> passengers;

    public TrainSegment(){

    }

    public TrainSegment(int id, int capacity){
        this.density = 0;
        this.id = id;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public ArrayList<Passenger> getPassengers(){
        return this.passengers;
    }

    public float getDensity() {
        return density;
    }

    public int getId(){
        return id;
    }


}
