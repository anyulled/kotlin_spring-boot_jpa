import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.2.61"
    java
    maven
    jacoco
    idea
    kotlin("jvm") version "1.2.61"
    id("net.saliman.cobertura") version "2.5.4"
    id("com.github.kt3k.coveralls") version "2.10.2"
    id("org.springframework.boot") version "2.0.2.RELEASE"
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    id("org.sonarqube") version "2.8"
}

group = "com.anyulled"
version = "0.0.1-SNAPSHOT"

description = "jpa demo"

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}
tasks.withType<JavaCompile> {
    val compilerArgs = options.compilerArgs
    compilerArgs.add("-Xdoclint:all,-missing")
    compilerArgs.add("-Xlint:all")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

jacoco {
    toolVersion = "0.8.1"
}

sonarqube {
    properties {
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

cobertura {
    coverageSourceDirs = mutableSetOf(project.rootDir)
}

repositories {
    mavenCentral()
}

dependencies {
    compile(group = "org.springframework.boot", name = "spring-boot-devtools", version = "2.0.4.RELEASE")
    compile(group = "org.springframework.boot", name = "spring-boot-starter-actuator", version = "2.0.4.RELEASE")
    compile(group = "org.springframework.boot", name = "spring-boot-starter-data-jpa", version = "2.0.4.RELEASE")
    compile(group = "org.springframework.boot", name = "spring-boot-starter-jdbc", version = "2.0.4.RELEASE")
    compile(group = "org.springframework.boot", name = "spring-boot-starter-web", version = "2.0.4.RELEASE")
    compile(group = "org.springframework.boot", name = "spring-boot-starter-webflux", version = "2.0.4.RELEASE")
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    compile(group = "org.hibernate", name = "hibernate-ehcache", version = "5.2.17.Final")
    compile(group = "com.fasterxml.jackson.module", name = "jackson-module-kotlin", version = "2.11.3")
    compile(group = "com.h2database", name = "h2", version = "1.4.200")
    compile(group = "io.github.microutils", name = "kotlin-logging", version = "1.12.0")
    compile(group = "io.springfox", name = "springfox-swagger2", version = "3.0.0")
    compile(group = "io.springfox", name = "springfox-swagger-ui", version = "3.0.0")
    compile(group = "io.sentry", name = "sentry-spring", version = "1.7.30")
    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))
    testCompile(group = "org.springframework.boot", name = "spring-boot-starter-test", version = "2.0.4.RELEASE")
    testCompile(group = "io.projectreactor", name = "reactor-test", version = "3.3.10.RELEASE")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.1.1")
    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine")
}
