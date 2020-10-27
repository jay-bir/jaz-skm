package pl.edu.pjwskt.pociongi_client.trains;


import pl.edu.pjwskt.pociongi_client.stations.Station;


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


}
