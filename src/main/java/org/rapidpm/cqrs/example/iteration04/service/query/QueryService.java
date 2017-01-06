package org.rapidpm.cqrs.example.iteration04.service.query;

import java.time.LocalDate;
import java.util.List;

public interface QueryService {
  List<String> getAvailableHotels(LocalDate from, LocalDate to);
}
