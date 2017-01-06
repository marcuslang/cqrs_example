package org.rapidpm.cqrs.example.iteration03.service.query;

import java.time.LocalDate;
import java.util.List;

public interface QueryService {
  List<String> getAvailableHotels(LocalDate from, LocalDate to);
}
