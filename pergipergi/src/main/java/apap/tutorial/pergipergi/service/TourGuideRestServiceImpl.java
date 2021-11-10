package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.repository.TourGuideDb;
import apap.tutorial.pergipergi.rest.PrediksiUmur;
import apap.tutorial.pergipergi.rest.Setting;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.io.DataInput;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class TourGuideRestServiceImpl implements TourGuideRestService{

    private final WebClient webClient;

    public TourGuideRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.umurUrl).build();
    }

    @Autowired
    private TourGuideDb tourGuideDb;

    @Override
    public TourGuideModel getTourGuideByNoTourGuide(Long noTourGuide) {
        Optional<TourGuideModel> tourGuide = tourGuideDb.findByNoTourGuide(noTourGuide);

        if(tourGuide.isPresent()){
            return tourGuide.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public TourGuideModel prediksiUmur(Long noTourGuide) throws IOException {
        TourGuideModel tourGuide = getTourGuideByNoTourGuide(noTourGuide);

        Mono<String> data = this.webClient.get().uri("?name={nama}", tourGuide.getNamaTourGuide()).retrieve().bodyToMono(String.class);

        String dataJSON = data.block();

        ObjectMapper objectMapper = new ObjectMapper();

        PrediksiUmur dataBaru = objectMapper.readValue(dataJSON, PrediksiUmur.class);

        tourGuide.setUmur(dataBaru.getAge());

        return tourGuide;
    }
}
