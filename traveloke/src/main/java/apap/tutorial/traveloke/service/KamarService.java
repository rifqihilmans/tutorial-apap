package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.KamarModel;

import java.util.List;

public interface KamarService {
    void addKamar(KamarModel kamar);

    List<KamarModel> findAllKamarByIdHotel(Long idHotel);

    KamarModel getKamarByNoKamar(Long noKamar);

    //Method untuk update kamar
    KamarModel updateKamar(KamarModel kamar);

    //Method untuk delete kamar
    void deleteKamar(KamarModel kamar);

    List<KamarModel> getKamarByNamaKamarDanKapasitas(String namaKamar, Integer kapasitasKamar);
}
