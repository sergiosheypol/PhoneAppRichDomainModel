package com.shpl.catalog;

import com.shpl.catalog.handler.CatalogHandler;
import com.shpl.catalog.mapper.PhoneMapper;
import com.shpl.catalog.mongo.MongoConfig;
import com.shpl.catalog.repository.CatalogRepository;
import com.shpl.catalog.repository.mongo.MongoCatalogRepository;
import com.shpl.catalog.router.CatalogRouter;
import com.shpl.catalog.service.CatalogService;

import static java.util.Objects.isNull;

public final class IoC {
  public CatalogService service;
  public CatalogRepository repository;
  public CatalogHandler handler;
  public CatalogRouter router;
  public PhoneMapper mapper;
  public MongoConfig mongo;

  private static IoC instance = null;

  public static synchronized IoC getInstance() {
    if (isNull(instance)) {
      instance = new IoC();
    }
    return instance;
  }

  private IoC() {
    this.mongo = new MongoConfig();
    this.mapper = new PhoneMapper();
    this.repository = new MongoCatalogRepository(this.mongo, this.mapper);
    this.service = new CatalogService(this.repository);
    this.handler = new CatalogHandler(this.service, this.mapper);
    this.router = new CatalogRouter(this.handler);

  }
}
