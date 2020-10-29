package pl.edu.pjwskt.pociongi_api.trains;

import pl.edu.pjwskt.pociongi_api.stations.Passenger;
import pl.edu.pjwskt.pociongi_api.stations.Station;

import java.util.ArrayList;


public class Train {
    private int id;
    private boolean forward;
    private Station station;
    private TrainSegment[] segments;

    public Train(int id, int numberOfSegments, int segmentCapacity){
        this.id = id;
        this.segments = new TrainSegment[numberOfSegments];
        for(int i = 0; i < numberOfSegments; i++){
            segments[i] = new TrainSegment(i, segmentCapacity);
        }
    }

    public boolean isForward(){
        return this.forward;
    }

    public void setForward(boolean forward){
        this.forward = forward;
    }

    public Station getStation(){
        return this.station;
    }

    public void setStation(Station station){
        this.station = station;
    }

    public void changeForward(){
        if(forward){
            if(station.isBackwardEmpty()){
                station.setTrainBackward(this);
                station.setTrainForward(null);
                forward = false;
            }
        }
        else{
            if(station.isForwardEmpty()){
                station.setTrainForward(this);
                station.setTrainBackward(null);
                forward = true;
            }
        }
    }

    public int getId(){
        return id;
    }

    public TrainSegment[] getSegments(){
        return segments;
    }

    public void loadPassengers(){
        ArrayList<Passenger> passengersOnStation = this.station.getPassengers();
        for(int i = passengersOnStation.size() - 1; i >= 0; i--){
            for(TrainSegment segment: segments){
                if(segment.getDensity() < 100){
                    segment.getPassengers().add(passengersOnStation.get(i));
                    segment.updateDensity();
                    passengersOnStation.remove(i);
                    break;
                }
                else break;
            }
            break;
        }
    }

    public void disposeOfPassengers(){
        for(TrainSegment segment: segments){
            ArrayList<Passenger> passInSeg = segment.getPassengers();
            for(int i = passInSeg.size() - 1; i > 0; i--){
                if(passInSeg.get(i).getDestination() == this.station.getName()){
                    passInSeg.remove(i);
                }
            }
            segment.updateDensity();
        }
    }


}
