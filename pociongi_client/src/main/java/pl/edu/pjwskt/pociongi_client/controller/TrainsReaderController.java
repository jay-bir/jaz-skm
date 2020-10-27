package pl.edu.pjwskt.pociongi_client.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwskt.pociongi_client.trains.Train;


import java.util.Arrays;
import java.util.List;

@RestController
public class TrainsReaderController {

    private final String URI = "http://pociongiapi:11111/trains";


    @GetMapping("/readTrains")
    public List<Train> getTrains(){
        RestTemplate template = new RestTemplate();

        Train[] trains = template.getForObject(URI,Train[].class);

        return Arrays.asList(trains);
    }

}
