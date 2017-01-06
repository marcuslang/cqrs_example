package org.rapidpm.cqrs.example.iteration04.dao.query;

import org.rapidpm.cqrs.example.iteration04.database.HotelDatabase;
import org.rapidpm.cqrs.example.iteration04.domain.Hotel;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

public class QueryDAO {

  private HotelDatabase hotelDatabase;

  @PostConstruct
  public void init() {
    hotelDatabase = HotelDatabase.getInstance();
  }

  public List<Hotel> getAllAvailableHotels(LocalDate from, LocalDate to) {
    return hotelDatabase.getAvailableHotels(from, to);
  }

}
