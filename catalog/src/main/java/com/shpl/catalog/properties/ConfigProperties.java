package com.shpl.catalog.properties;

import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;

import java.util.Optional;

public final class ConfigProperties {

  public static Integer getPort() {
    return (Integer) getServerProperties().getValue("port");
  }

  private static JsonObject getServerProperties() {
    return (JsonObject) Vertx.currentContext().config().getValue("server");
  }

  public static JsonObject getMongoProperties() {
    return (JsonObject) Vertx.currentContext().config().getValue("mongo");
  }

}
