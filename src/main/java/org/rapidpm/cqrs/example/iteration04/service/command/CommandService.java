package org.rapidpm.cqrs.example.iteration04.service.command;

import java.time.LocalDate;

public interface CommandService {
  void bookHotel(String hotelName, LocalDate from, LocalDate to);
}
