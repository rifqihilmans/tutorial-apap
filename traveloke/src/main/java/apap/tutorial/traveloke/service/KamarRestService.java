package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarRestService {

    KamarModel createKamar(KamarModel kamar);

    KamarModel changeKamar(Long noKamar, KamarModel kamarUpdate);

    KamarModel getKamarByNoKamar(Long noKamar);

    List<KamarModel> retrieveListKamar();

    void deleteKamar(Long noKamar);
}
