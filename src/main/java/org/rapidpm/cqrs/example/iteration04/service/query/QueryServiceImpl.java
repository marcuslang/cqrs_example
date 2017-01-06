package org.rapidpm.cqrs.example.iteration04.service.query;

import org.rapidpm.cqrs.example.iteration02.model.HotelModel;
import org.rapidpm.cqrs.example.iteration02.service.query.QueryService;
import org.rapidpm.ddi.DI;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

public class QueryServiceImpl implements QueryService {

  @Inject
  private HotelModel model;

  public QueryServiceImpl() {
    DI.activateDI(this);
  }

  @Override
  public List<String> getAllAvailableHotels(LocalDate from, LocalDate to) {
    return model.getAllAvailableHotels(from, to);
  }

}
