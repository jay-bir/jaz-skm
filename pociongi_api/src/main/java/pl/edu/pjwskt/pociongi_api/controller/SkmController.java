package pl.edu.pjwskt.pociongi_api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjwskt.pociongi_api.simulation.Skm;
import pl.edu.pjwskt.pociongi_api.stations.Station;
import pl.edu.pjwskt.pociongi_api.trains.Train;

import java.util.List;

@RestController
public class SkmController {

    private Skm skm;



    @Autowired
    public SkmController(@Value("${trains}")final int x,@Value("${segments}") final int y, @Value("${capacity}") final int z){
        skm = new Skm(x,y,z);
    }

    @GetMapping("/trains")
    public List<Train> getTrains() {return skm.getTrains();}

    @GetMapping("/stations")
    public List<Station> getStations(){return skm.getStations();}

    @GetMapping("/move")
    public void move(){
        skm.move();
    }

    @GetMapping("/trains/{id}")
    public Train trainInfo(@PathVariable int id){
        return skm.getTrains().get(id);
    }
}
