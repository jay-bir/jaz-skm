package pl.edu.pjwskt.pociongi_api.trains;

import pl.edu.pjwskt.pociongi_api.stations.Passenger;

import java.util.ArrayList;

public class TrainSegment {
    private int id;
    private int capacity;
    private float density;
    private ArrayList<Passenger> passengers;

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

    public void updateDensity(){
        this.density = (passengers.size() / capacity) * 100;
    }
}
