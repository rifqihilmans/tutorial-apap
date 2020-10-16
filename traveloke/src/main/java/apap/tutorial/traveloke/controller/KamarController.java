package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = new ArrayList<KamarModel>();
        hotel.setListKamar(listKamar);
        hotel.getListKamar().add(new KamarModel());
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @PostMapping(value = "/kamar/add/{idHotel}", params = {"addRow"})
    private String addRowKamar(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        if(hotel.getListKamar()==null || hotel.getListKamar().size()==0){
            hotel.setListKamar(new ArrayList<KamarModel>());
        }
        hotel.getListKamar().add(new KamarModel());
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @PostMapping(value = "/kamar/add/{idHotel}", params = {"deleteRow"})
    private String deleteRowKamar(
            @ModelAttribute HotelModel hotel,
            HttpServletRequest request,
            Model model
    ){
        Integer rowId = Integer.valueOf(request.getParameter("deleteRow"));
        hotel.getListKamar().remove(rowId.intValue());
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @PostMapping(value = "/kamar/add/", params = {"save"})
    private String addKamarSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        for (KamarModel kamar : hotel.getListKamar()){
            kamar.setHotel(hotel);
            kamarService.addKamar(kamar);
        }
        model.addAttribute("listKamar", hotel.getListKamar());
        return "add-kamar";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarFormPage(
            @PathVariable Long noKamar,
            Model model
    ){
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(noKamar);
        kamar.setHotel(hotel);
        model.addAttribute("kamar", kamar);
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeKamarFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        KamarModel kamarModel = kamarService.updateKamar(kamar);
        model.addAttribute("kamar", kamar);

        return "update-kamar";
    }

    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount", hotel.getListKamar().size());
        for(KamarModel kamar : hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }
        boolean exists = true;
        if (hotel.getListKamar().size() > 0){
            exists = true;
        }else{
            exists = false;
        }
        model.addAttribute("exists", exists);
        return "delete-kamar";
    }
}
