package com.shpl.catalog;

import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.Json;
import io.vertx.reactivex.ext.web.RoutingContext;

public class RestHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(RestHandler.class);

  private final MongoRepository repository;

  public RestHandler(final MongoRepository repository) {
    this.repository = repository;
  }

  @SuppressWarnings("CheckReturnValue")
  public void getCatalog(final RoutingContext ctx) {
    repository.getAll()
      .map(Phone::toJson)
      .toList()
      .subscribe(l -> {
        LOGGER.info("Catalog retrieved successfully");
        ctx.response()
          .putHeader("Content-Type", "application/json")
          .end(Json.encodePrettily(l));
      });
  }
}
