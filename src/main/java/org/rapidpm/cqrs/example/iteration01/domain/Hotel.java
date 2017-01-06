package org.rapidpm.cqrs.example.iteration01.domain;


import java.time.LocalDate;
import java.util.List;

public class Hotel {

  private String hotelName;
  private List<LocalDate> bookings;

  public Hotel(String hotelName, List<LocalDate> bookings) {
    this.hotelName = hotelName;
    this.bookings = bookings;
  }

  public boolean isBookedOnDates(List<LocalDate> dates) {
    for(LocalDate date : dates)
      return bookings.contains(date);
    return false;
  }

  public String getHotelName() {
    return hotelName;
  }

  public void addBooking(List<LocalDate> days) {
    bookings.addAll(days);
  }
}
