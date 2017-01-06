package org.rapidpm.cqrs.example.iteration03.dao;

import org.rapidpm.cqrs.example.iteration03.database.HotelDatabase;
import org.rapidpm.cqrs.example.iteration03.domain.Hotel;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

public class HotelDAO {

  private HotelDatabase hotelDatabase;

  @PostConstruct
  public void init() {
    hotelDatabase = HotelDatabase.getInstance();
  }

  public List<Hotel> getAllAvailableHotels(LocalDate from, LocalDate to) {
    return hotelDatabase.getAvailableHotels(from, to);
  }

  public void bookHotel(String hotelName, LocalDate from, LocalDate to) {
    hotelDatabase.addBooking(hotelName, from, to);
  }
}
