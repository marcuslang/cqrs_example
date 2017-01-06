package org.rapidpm.cqrs.example.iteration01.model;

import org.rapidpm.cqrs.example.iteration01.dao.HotelDAO;
import org.rapidpm.cqrs.example.iteration01.dao.HotelDAO;
import org.rapidpm.cqrs.example.iteration01.domain.Hotel;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

public class HotelModel {

  @Inject
  private HotelDAO dao;

  public List<Hotel> getAllAvailableHotels(LocalDate from, LocalDate to) {
    return dao.getAllAvailableHotels(from, to);
  }

  public void bookHotel(String hotelName, LocalDate from, LocalDate to) {
    dao.bookHotel(hotelName, from, to);
  }
}
