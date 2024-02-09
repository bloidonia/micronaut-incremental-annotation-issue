plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.3.1"
}

version = "0.1"
group = "bootTestJava"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    annotationProcessor("io.micronaut.spring:micronaut-spring-annotation")
    annotationProcessor("io.micronaut.spring:micronaut-spring-boot-annotation")

    implementation("io.micronaut.spring:micronaut-spring-context")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")

    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("io.micronaut.spring:micronaut-spring-boot")

    testAnnotationProcessor("io.micronaut.spring:micronaut-spring-boot-annotation")
    testImplementation("io.micronaut:micronaut-http-client")
}


application {
    mainClass.set("bootTestJava.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("bootTestJava.*")
    }
}



