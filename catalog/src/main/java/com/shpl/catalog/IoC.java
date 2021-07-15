package com.shpl.catalog;

import static java.util.Objects.isNull;

public final class IoC {
  public RestHandler handler;
  public RestRouter router;
  public MongoConfig mongo;
  public MongoRepository repository;

  private static IoC instance = null;

  public static synchronized IoC getInstance() {
    if (isNull(instance)) {
      instance = new IoC();
    }
    return instance;
  }

  private IoC() {
    this.mongo = new MongoConfig();
    this.repository = new MongoRepository(this.mongo);
    this.handler = new RestHandler(this.repository);
    this.router = new RestRouter(this.handler);

  }
}
