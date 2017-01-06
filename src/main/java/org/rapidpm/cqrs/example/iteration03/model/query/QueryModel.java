package org.rapidpm.cqrs.example.iteration03.model.query;

import org.rapidpm.cqrs.example.iteration03.dao.HotelDAO;
import org.rapidpm.cqrs.example.iteration03.domain.Hotel;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QueryModel {

  @Inject
  private HotelDAO dao;

  public List<String> getAllAvailableHotels(LocalDate from, LocalDate to) {
    if (from.isBefore(to) && from.isAfter(LocalDate.now()) && to.isAfter(LocalDate.now())) {
      return dao.getAllAvailableHotels(from, to).stream()
          .map(Hotel::getHotelName)
          .collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

}
