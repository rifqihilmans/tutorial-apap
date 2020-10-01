package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //Routing URL yang diinginkan
    @RequestMapping("/hotel/add")
    public String addHotel(
            //Request parameter yang ingin dibawa
            @RequestParam(value = "idHotel", required = true) String idHotel,
            @RequestParam(value = "namaHotel", required = true) String namaHotel,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
            ){

        //Membuat objek HotelModel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        //Memanggil service addHotel
        hotelService.addHotel(hotel);

        //Add variabel id hotel ke 'idHotel' untuk dirender pada thymeleaf
        model.addAttribute("idHotel", idHotel);

        //Return view template yang digunakan
        return "add-hotel";
    }
}
