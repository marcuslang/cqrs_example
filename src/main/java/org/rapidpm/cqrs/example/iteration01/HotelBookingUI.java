package org.rapidpm.cqrs.example.iteration01;

import org.rapidpm.cqrs.example.iteration01.service.HotelBookingService;

import java.time.LocalDate;
import java.util.List;

public class HotelBookingUI {


  public static void main(String[] args) {
    HotelBookingService service = new HotelBookingService();
    LocalDate from = LocalDate.parse("2020-01-01");
    LocalDate to = LocalDate.parse("2020-01-03");

    List<String> availableHotels = service.getAllAvailableHotels(from, to);
    System.out.println("\nAvailable hotels:");
    availableHotels.forEach(System.out::println);

    service.bookHotel(availableHotels.get(0), from, to);

    List<String> nowAvailableHotels = service.getAllAvailableHotels(from, to);
    System.out.println("\nAvailable hotels after booking:");
    nowAvailableHotels.forEach(System.out::println);
  }


}
