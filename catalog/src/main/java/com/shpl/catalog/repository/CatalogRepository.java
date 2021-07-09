package com.shpl.catalog.repository;

import com.shpl.catalog.model.PhoneModel;
import io.reactivex.Flowable;

public interface CatalogRepository {
  Flowable<PhoneModel> getAll();
}
