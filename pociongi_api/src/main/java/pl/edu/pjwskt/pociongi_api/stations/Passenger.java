package pl.edu.pjwskt.pociongi_api.stations;

import java.util.Random;

public class Passenger {
    private static String[] possibleNames = {"Jan Kowalsko", "Mateusz Nowak", "Karolina Debska", "Krzysztof Gonciarz", "Hugh Jackman", "Natalie Portman", "John Placeholder",
                                             "Angelina Jolie", "Bradd Pitt", " Zhack Braff", "Edyta Gorniak", "Urszula Dudziak"};

    private String name;
    private String destination;


    public Passenger(String[] destinations){
        Random random = new Random();
        name = possibleNames[random.nextInt(possibleNames.length)];
        destination = destinations[random.nextInt(destinations.length)];
    }

    public String getDestination(){
        return this.destination;
    }

    public String getName() {
        return name;
    }
}
