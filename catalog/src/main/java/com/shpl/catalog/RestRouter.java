package com.shpl.catalog;

import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class RestRouter {

  private final RestHandler handler;

  public RestRouter(final RestHandler handler) {
    this.handler = handler;
  }

  public Router configureRouting() {
    Router router = Router.router(Vertx.currentContext().owner());
    router.get("/catalog").handler(handler::getCatalog);
    return router;
  }
}
