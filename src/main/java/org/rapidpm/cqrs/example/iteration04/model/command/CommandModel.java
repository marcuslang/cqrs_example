package org.rapidpm.cqrs.example.iteration04.model.command;

import org.rapidpm.cqrs.example.iteration04.dao.command.CommandDAO;

import javax.inject.Inject;
import java.time.LocalDate;

public class CommandModel {

  @Inject
  private CommandDAO dao;

  public void bookHotel(String hotelName, LocalDate from, LocalDate to) {
    dao.bookHotel(hotelName, from, to);
  }
}
