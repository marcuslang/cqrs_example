package org.rapidpm.cqrs.example.iteration04.dao.command;

import org.rapidpm.cqrs.example.iteration04.database.HotelDatabase;
import org.rapidpm.cqrs.example.iteration04.domain.Hotel;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

public class CommandDAO {

  private HotelDatabase hotelDatabase;

  @PostConstruct
  public void init() {
    hotelDatabase = HotelDatabase.getInstance();
  }

  public void bookHotel(String hotelName, LocalDate from, LocalDate to) {
    hotelDatabase.addBooking(hotelName, from, to);
  }
}
