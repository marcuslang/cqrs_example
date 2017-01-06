package org.rapidpm.cqrs.example.iteration03.database;

import org.rapidpm.cqrs.example.iteration03.domain.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.temporal.ChronoUnit.DAYS;

public class HotelDatabase {

  private static HotelDatabase instance;
  private List<Hotel> hotels;

  public HotelDatabase() {
    hotels = new ArrayList<>(3);
    hotels.add(new Hotel("Guest House Noose", new LinkedList<>()));
    hotels.add(new Hotel("Five Seasons", new LinkedList(Arrays.asList(LocalDate.now()))));
    hotels.add(new Hotel("Grillton", new LinkedList<>(Arrays.asList(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 2)))));
  }

  public static HotelDatabase getInstance() {
    if (instance == null) {
      instance = new HotelDatabase();
    }
    return instance;
  }

  public List<Hotel> getAvailableHotels(LocalDate from, LocalDate to) {
    final List<LocalDate> daysBetween = getDaysBetween(from, to);

    return hotels.stream()
        .filter(hotel -> !hotel.isBookedOnDates(daysBetween))
        .collect(Collectors.toList());
  }

  public void addBooking(String hotelName, LocalDate from, LocalDate to) {
    final List<LocalDate> daysBetween = getDaysBetween(from, to);

    hotels.stream()
        .filter(hotel -> hotel.getHotelName().equals(hotelName))
        .findAny()
        .ifPresent(hotel -> hotel.addBooking(daysBetween));
  }

  private List<LocalDate> getDaysBetween(LocalDate from, LocalDate to) {
    return IntStream.range(0, (int) DAYS.between(from, to)).mapToObj(from::plusDays).collect(Collectors.toList());
  }
}
