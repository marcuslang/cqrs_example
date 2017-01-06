package org.rapidpm.cqrs.example.iteration01.service;

import org.rapidpm.cqrs.example.iteration01.domain.Hotel;
import org.rapidpm.cqrs.example.iteration01.model.HotelModel;
import org.rapidpm.ddi.DI;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HotelBookingService{

  @Inject
  private HotelModel model;

  public HotelBookingService() {
    DI.activatePackages("org.rapidpm");
    DI.activateDI(this);
  }

  public List<String> getAllAvailableHotels(LocalDate from, LocalDate to) {
    if (from.isBefore(to) && from.isAfter(LocalDate.now()) && to.isAfter(LocalDate.now())) {
      return model.getAllAvailableHotels(from, to).stream()
          .map(Hotel::getHotelName)
          .collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

  public void bookHotel(String hotelName, LocalDate from, LocalDate to) {
    model.bookHotel(hotelName, from, to);
  }
}
