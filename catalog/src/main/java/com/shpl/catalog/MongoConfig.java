package com.shpl.catalog;

import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.mongo.MongoClient;

public class MongoConfig {
  private final MongoClient mongoClient;

  public MongoConfig() {
    this.mongoClient = MongoClient.createShared(Vertx.currentContext().owner(), ConfigProperties.getMongoProperties());
  }

  public MongoClient getMongoClient() {
    return mongoClient;
  }
}
