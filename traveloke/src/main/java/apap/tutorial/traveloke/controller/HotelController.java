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

import java.util.Collections;
import java.util.List;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
            ){
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if(hotel != null){
            model.addAttribute("hotel", hotel);
            return "form-update-hotel";
        }else{
            return "error-page";
        }

    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
            @RequestParam(value = "idHotel") Long idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        boolean kamarKosong = true;
        if (kamarService.findAllKamarByIdHotel(idHotel).size() != 0 && hotel != null){
            kamarKosong = true;
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
            model.addAttribute("hotel", hotel);
            model.addAttribute("listKamar", listKamar);
            model.addAttribute("kamarKosong", kamarKosong);
            return "view-hotel";
        }else if(kamarService.findAllKamarByIdHotel(idHotel).size() == 0 && hotel != null){
            kamarKosong = false;
            model.addAttribute("hotel", hotel);
            model.addAttribute("kamarKosong", kamarKosong);
            return "view-hotel";
        }else if(kamarService.findAllKamarByIdHotel(idHotel).size() == 0 && hotel == null){
            return "error-page";
        }else{
            return "error-page";
        }

    }

    @GetMapping("/hotel/delete/{idHotel}")
    public String deleteHotel(
            @PathVariable Long idHotel,
            Model model
    ){
        HotelModel hotelModel = hotelService.getHotelByIdHotel(idHotel);
        boolean kamarKosong = true;
        if(kamarService.findAllKamarByIdHotel(idHotel).size() == 0 && hotelModel != null){
            kamarKosong = true;
            hotelService.deleteHotel(hotelModel);
            model.addAttribute("kamarKosong", kamarKosong);
            model.addAttribute("hotelModel", hotelModel);
            return "delete-hotel";
        }else if(kamarService.findAllKamarByIdHotel(idHotel).size() != 0 && hotelModel != null){
            kamarKosong = false;
            model.addAttribute("kamarKosong", kamarKosong);
            model.addAttribute("hotelModel", hotelModel);
            return "delete-error";
        }else if(hotelModel == null){
            return "error-page";
        }else{
            return "error-page";
        }
    }

    @GetMapping("/hotel/view-all")
    public String viewAllHotel(Model model){
        List<HotelModel> listHotel = hotelService.getHotelListSorted();

        model.addAttribute("listHotel", listHotel);

        return "view-all-hotel";

    }
}
