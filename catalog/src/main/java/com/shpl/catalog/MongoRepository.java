package com.shpl.catalog;

import io.reactivex.Flowable;
import io.vertx.core.json.JsonObject;

public class MongoRepository {

  public static final String CATALOG_COLLECTION = "catalog";

  private final MongoConfig mongoConfig;

  public MongoRepository(final MongoConfig mongoConfig) {
    this.mongoConfig = mongoConfig;
  }

  public Flowable<Phone> getAll() {
    return mongoConfig.getMongoClient()
      .findBatch(CATALOG_COLLECTION, new JsonObject())
      .toFlowable()
      .map(Phone::fromMongo);
  }
}
