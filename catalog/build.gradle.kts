import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
  java
  application
  id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.shpl"
version = "1.0.0-SNAPSHOT"

repositories {
  mavenCentral()
}

val vertxVersion = "4.0.3"
val junitJupiterVersion = "5.7.0"

val doOnChange = "${projectDir}/gradlew classes"



dependencies {

  // Jackson
  implementation(platform("io.vertx:vertx-stack-depchain:$vertxVersion"))
  implementation("io.vertx:vertx-rx-java2")
  implementation("io.vertx:vertx-web")
  compile("io.vertx:vertx-pg-client:$vertxVersion")
  compile("io.vertx:vertx-mongo-client:$vertxVersion")
  implementation ("com.fasterxml.jackson.core", "jackson-databind",  "2.0.1")
  testImplementation("io.vertx:vertx-junit5")
  testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
  implementation("io.vertx:vertx-config:$vertxVersion")
  implementation("io.vertx:vertx-config-yaml:$vertxVersion")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}


tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events = setOf(PASSED, SKIPPED, FAILED)
  }
}

