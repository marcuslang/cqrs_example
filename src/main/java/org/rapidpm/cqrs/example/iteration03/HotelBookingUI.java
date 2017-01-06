package org.rapidpm.cqrs.example.iteration03;

import org.rapidpm.cqrs.example.iteration02.service.command.CommandService;
import org.rapidpm.cqrs.example.iteration02.service.command.CommandServiceImpl;
import org.rapidpm.cqrs.example.iteration02.service.query.QueryService;
import org.rapidpm.cqrs.example.iteration02.service.query.QueryServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class HotelBookingUI {


  public static void main(String[] args) {
    QueryService queryService = new QueryServiceImpl();
    CommandService commandService = new CommandServiceImpl();

    LocalDate from = LocalDate.parse("2020-01-01");
    LocalDate to = LocalDate.parse("2020-01-03");

    List<String> availableHotels = queryService.getAllAvailableHotels(from, to);
    System.out.println("\nAvailable hotels:");
    availableHotels.forEach(System.out::println);

    commandService.bookHotel(availableHotels.get(0), from, to);

    List<String> nowAvailableHotels = queryService.getAllAvailableHotels(from, to);
    System.out.println("\nAvailable hotels after booking:");
    nowAvailableHotels.forEach(System.out::println);

  }


}
