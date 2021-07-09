package com.shpl.catalog.service;

import com.shpl.catalog.model.PhoneModel;
import com.shpl.catalog.repository.CatalogRepository;
import io.reactivex.Flowable;

public class CatalogService {

  private final CatalogRepository repository;

  public CatalogService(final CatalogRepository repository) {
    this.repository = repository;
  }

  public Flowable<PhoneModel> getAll() {
    return this.repository.getAll();
  }
}
