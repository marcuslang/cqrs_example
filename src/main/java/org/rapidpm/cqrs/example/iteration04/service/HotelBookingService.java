package org.rapidpm.cqrs.example.iteration04.service;

import org.rapidpm.cqrs.example.iteration04.service.command.CommandService;
import org.rapidpm.cqrs.example.iteration04.service.query.QueryService;
import org.rapidpm.ddi.DI;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class HotelBookingService {

  @Inject
  private CommandService commandService;
  @Inject
  private QueryService queryService;


  public HotelBookingService() {
    DI.activatePackages("org.rapidpm");
    DI.activateDI(this);
  }

  public List<String> getAllAvailableHotels(LocalDate from, LocalDate to) {
    if (from.isBefore(to) && from.isAfter(LocalDate.now()) && to.isAfter(LocalDate.now())) {
      return queryService.getAvailableHotels(from, to);
    }
    return Collections.emptyList();
  }

  public void bookHotel(String hotelName, LocalDate from, LocalDate to) {
    commandService.bookHotel(hotelName, from, to);
  }
}
