# PhoneApp - MonoRepo

[![Vertx](https://img.shields.io/badge/vert.x-4.0.3-purple.svg)](link="https://vertx.io")

This project aims to serve as an example on how to refactor a Repository-Service type of application
to a Rich Domain Model type to step away from old monolithic Java designs.

It uses MongoDB. Since this is an example, we'll use a Dockerized Mongo. See [mongo folder](/mongo).

## Tech Stack
* Java 11
* Vert.x 4.0.3
* MongoDB
* [Bazel](https://bazel.build)
* Gradle

## Requisites

* Java 11
* Docker

Optional:
* Bazel

## How to run

I'm using [Bazel](https://bazel.build) for running it but Gradle is also available for IntelliJ support.

The app starts on the port 80

### Prerequisites
1. Initialize mongo by running the `mongo/init.sh` script. Don't forget to use `mongo/kill.sh` to delete the container

### Running with Gradle and IntelliJ
1. Open `App.java` and hit RUN in IntelliJ (executing the Main method)

### Running with Bazel
1. `cd catalog`
1. `bazel run :service`



## Endpoints
* GET: /catalog

### Example cURL
```
curl --location --request GET 'localhost:80/catalog'
```
