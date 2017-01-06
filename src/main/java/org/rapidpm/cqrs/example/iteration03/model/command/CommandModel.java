package org.rapidpm.cqrs.example.iteration03.model.command;

import org.rapidpm.cqrs.example.iteration03.dao.HotelDAO;

import javax.inject.Inject;
import java.time.LocalDate;

public class CommandModel {

  @Inject
  private HotelDAO dao;

  public void bookHotel(String hotelName, LocalDate from, LocalDate to) {
    dao.bookHotel(hotelName, from, to);
  }
}
