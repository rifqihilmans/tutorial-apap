//package apap.tutorial.traveloke.service;
//
//import apap.tutorial.traveloke.model.HotelModel;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class HotelInMemoryService implements HotelService{
//    private List<HotelModel> listHotel;
//
//    //Constructor
//    public HotelInMemoryService() {
//        listHotel = new ArrayList<>();
//    }
//
//    @Override
//    public void addHotel(HotelModel hotel) {
//        listHotel.add(hotel);
//    }
//
//    @Override
//    public List<HotelModel> getHotelList() {
//        return listHotel;
//    }
//
//    @Override
//    public HotelModel getHotelByIdHotel(Long idHotel) {
//        return null;
//    }
//
//    @Override
//    public HotelModel updateHotel(HotelModel hotel) {
//        return null;
//    }
//
//    @Override
//    public List<HotelModel> getHotelListSorted() {
//        return null;
//    }
//
//    //    @Override
////    public HotelModel getHotelByIdHotel(String idHotel) {
////        HotelModel hotelID = null;
////        for (int i = 0; i < listHotel.size(); i++) {
////            String id = listHotel.get(i).getIdHotel();
////            if(id.equals(idHotel)){
////                hotelID = listHotel.get(i);
////            }
////        }
////        return hotelID;
////    }
//
//    @Override
//    public void deleteHotel(HotelModel hotel) {
//        System.out.println("null");
//    }
//}
