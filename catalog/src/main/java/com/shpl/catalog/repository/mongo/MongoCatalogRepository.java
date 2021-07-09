package com.shpl.catalog.repository.mongo;

import com.shpl.catalog.model.PhoneModel;
import com.shpl.catalog.mapper.PhoneMapper;
import com.shpl.catalog.repository.CatalogRepository;
import com.shpl.catalog.mongo.MongoConfig;
import io.reactivex.Flowable;
import io.vertx.core.json.JsonObject;

public class MongoCatalogRepository implements CatalogRepository {

  public static final String CATALOG_COLLECTION = "catalog";

  private final MongoConfig mongoConfig;
  private final PhoneMapper mapper;

  public MongoCatalogRepository(final MongoConfig mongoConfig, final PhoneMapper mapper) {
    this.mongoConfig = mongoConfig;
    this.mapper = mapper;
  }

  @Override
  public Flowable<PhoneModel> getAll() {
    return mongoConfig.getMongoClient()
      .findBatch(CATALOG_COLLECTION, new JsonObject())
      .toFlowable()
      .map(mapper::toModelFromMongo);
  }
}
