package pl.edu.pjwskt.pociongi_api.simulation;


import pl.edu.pjwskt.pociongi_api.stations.Station;
import pl.edu.pjwskt.pociongi_api.trains.Train;

import java.util.*;


public class Skm {

    private List<Train> trains;
    private LinkedList<Station> stations;
    private static final String[] stationNames = {"Gdynia Glowna", "Gdynia Wzgorze sw Maksymiliana","Gdynia Redlowo", "Gdynia Redlowo", "Sopot Kamienny Potok",
                                                  "Sopot", "Sopot Wyscigi","Gdansk Zabianka-AWFiS", "Gdansk Oliwa","Gdansk Przymorze-Uniwersytet","Gdansk Zaspa",
                                                  "Gdansk Wrzeszcz", "Gdansk Politechnika", "Gdansk Glowny","Gdansk Srodmiescie"};

    public Skm(int numberOfTrains, int numberOfSegments, int segmentCapacity ){
        Random rand = new Random();

        stations = new LinkedList<>();
            for(String stationName: stationNames){
                stations.add(new Station(stationName));
            }

        trains = new ArrayList<>();
        for(int i= 0; i < numberOfTrains; i++){
            trains.add(new Train(i,numberOfSegments,segmentCapacity));
        }

        for(Train train: trains){
            while(train.getStation() == null){
                int random = rand.nextInt(stationNames.length);
                if(stations.get(random).isForwardEmpty()){
                    train.setForward(true);
                    stations.get(random).setTrainForward(train);
                }
                else if(stations.get(random).isBackwardEmpty()){
                    train.setForward(false);
                    stations.get(random).setTrainBackward(train);
                }
                else continue;
                train.setStation(stations.get(random));
            }
        }
    }

    public void move(){
        for(Train train: trains){
            train.getStation().generatePassengers(Skm.stationNames);
            train.loadPassengers();

            ListIterator<Station> iterator = stations.listIterator(stations.indexOf(train.getStation()));
            if(train.isForward()){
                iterator.next();
                if(iterator.hasNext()){
                    train.getStation().setTrainForward(null);
                    train.setStation(iterator.next());
                    train.getStation().setTrainForward(train);
                }
                else{
                    train.changeForward();
                }
            }
            else{
                if(iterator.hasPrevious()){
                    train.getStation().setTrainBackward(null);
                    train.setStation(iterator.previous());
                    train.getStation().setTrainBackward(train);
                }
                else{
                    train.changeForward();
                }
            }
            train.disposeOfPassengers();
        }
    }

    public List<Train> getTrains(){
        return this.trains;
    }

    public LinkedList<Station> getStations(){
        return this.stations;
    }
}
