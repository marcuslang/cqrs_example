package org.rapidpm.cqrs.example.iteration01.service;

import org.rapidpm.cqrs.example.iteration01.model.HotelModel;
import org.rapidpm.ddi.DI;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

public class HotelBookingService{

  @Inject
  private HotelModel model;

  public HotelBookingService() {
    DI.activatePackages("org.rapidpm");
    DI.activateDI(this);
  }

  public List<String> getAllAvailableHotels(LocalDate from, LocalDate to) {
    return model.getAllAvailableHotels(from, to);
  }

  public void bookHotel(String hotelName, LocalDate from, LocalDate to) {
    model.bookHotel(hotelName, from, to);
  }
}
