package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import apap.tutorial.traveloke.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class KamarRestServiceImpl implements KamarRestService{
    private WebClient webClient;

    @Autowired
    private KamarDb kamarDb;

    @Override
    public KamarModel createKamar(KamarModel kamar) {
        return kamarDb.save(kamar);
    }

    @Override
    public KamarModel changeKamar(Long noKamar, KamarModel kamarUpdate) {
        KamarModel kamar = getKamarByNoKamar(noKamar);
        kamar.setNamaKamar(kamarUpdate.getNamaKamar());
        kamar.setKapasitasKamar(kamarUpdate.getKapasitasKamar());
        kamar.setTipe(kamarUpdate.getTipe());
        return kamarDb.save(kamar);
    }

    @Override
    public KamarModel getKamarByNoKamar(Long noKamar) {
        Optional<KamarModel> kamar = kamarDb.findById(noKamar);
        if (kamar.isPresent()){
            return kamar.get();
        }else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<KamarModel> retrieveListKamar() {
        return kamarDb.findAll();
    }

    @Override
    public void deleteKamar(Long noKamar) {
        KamarModel kamar = getKamarByNoKamar(noKamar);
        kamarDb.delete(kamar);
    }

    @Override
    public Mono<String> getApi(String city) {
        return this.webClient.get().uri("https://hotels-com-free.p.rapidapi.com/suggest/v1.7/json?query="+ city + "&locale=en_US")
                .header("x-rapidapi-key", "3d64ed7b00msh41118dafcfff79ap187941jsnba4c860ecd43")
                .header("x-rapidapi-host", "hotels-com-free.p.rapidapi.com")
                .header("useQueryString", "true")
                .retrieve().bodyToMono(String.class);
    }

    public KamarRestServiceImpl(WebClient.Builder webBuilder){
        this.webClient = webBuilder.baseUrl(Setting.hotelsAPIUrl).build();
    }
}
