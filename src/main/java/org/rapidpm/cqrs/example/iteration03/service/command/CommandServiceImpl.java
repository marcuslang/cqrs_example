package org.rapidpm.cqrs.example.iteration03.service.command;


import org.rapidpm.cqrs.example.iteration02.model.HotelModel;
import org.rapidpm.cqrs.example.iteration02.service.command.CommandService;
import org.rapidpm.ddi.DI;

import javax.inject.Inject;
import java.time.LocalDate;

public class CommandServiceImpl implements CommandService {

  @Inject
  private HotelModel model;

  public CommandServiceImpl() {
    DI.activateDI(this);
  }

  @Override
  public void bookHotel(String hotelName, LocalDate from, LocalDate to) {
    model.bookHotel(hotelName, from, to);
  }
}
