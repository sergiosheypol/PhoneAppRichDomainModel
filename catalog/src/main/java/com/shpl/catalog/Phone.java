package com.shpl.catalog;

import io.vertx.core.json.JsonObject;

public final class Phone {

  // PHONE MODEL
  public static final String ID = "id";
  public static final String NAME = "name";
  public static final String IMG = "img";
  public static final String DESCRIPTION = "description";
  public static final String PRICE = "price";

  // PRICE MODEL
  public static final String CURRENCY = "currency";
  public static final String VALUE = "value";

  private static final String MONGO_ID = "_id";

  private final JsonObject json;

  private Phone(final JsonObject json) {
    this.json = json;
  }

  public static Phone fromMongo (final JsonObject json) {
    final JsonObject model = json.copy();
    model.remove(MONGO_ID);
    model.put(ID, json.getString(MONGO_ID));
    return new Phone(model);
  }

  public JsonObject toJson() {
    return this.json;
  }

}
