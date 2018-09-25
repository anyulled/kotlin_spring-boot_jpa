<img src="https://github.com/JetBrains/kotlin-workshop/blob/master/kotlinlogo.png" width="24"/> Kotlin JPA Demo 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5497c68bc3ec4038bc6b38706c0d92ba)](https://app.codacy.com/app/anyulled/kotlin_spring-boot_jpa?utm_source=github.com&utm_medium=referral&utm_content=anyulled/kotlin_spring-boot_jpa&utm_campaign=Badge_Grade_Settings)
[![Build Status](https://travis-ci.com/anyulled/kotlin_spring-boot_jpa.svg?branch=master)](https://travis-ci.com/anyulled/kotlin_spring-boot_jpa)
[![codecov](https://codecov.io/gh/anyulled/kotlin_spring-boot_jpa/branch/master/graph/badge.svg)](https://codecov.io/gh/anyulled/kotlin_spring-boot_jpa)
[![Maintainability](https://api.codeclimate.com/v1/badges/a10d87df5e5803a64feb/maintainability)](https://codeclimate.com/github/anyulled/kotlin_spring-boot_jpa/maintainability)
[![Documentation](https://codedocs.xyz/anyulled/kotlin_spring-boot_jpa.svg)](https://codedocs.xyz/anyulled/kotlin_spring-boot_jpa/)
[![Sonarqube](https://sonarcloud.io/api/project_badges/measure?project=com.anyulled%3Ajpademo&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.anyulled%3Ajpademo)
[![Coverage Status](https://coveralls.io/repos/github/anyulled/kotlin_spring-boot_jpa/badge.svg?branch=master)](https://coveralls.io/github/anyulled/kotlin_spring-boot_jpa?branch=master)
[![CII Best Practices](https://bestpractices.coreinfrastructure.org/projects/2243/badge)](https://bestpractices.coreinfrastructure.org/projects/2243)
[![Heroku](http://heroku-badges.herokuapp.com/?app=kotlinjpademo&root=actuator/health)](https://kotlinjpademo.herokuapp.com/swagger-ui.html)
---

A showcase of different entity mappings with JPA & Hibernate.

Simply do `mvn spring-boot:run` a make a request to the described mappings on the controller

- [x] `@OneToOne`
- [ ] `@OneToMany` Issue #11
- [ ] `@ManyToMany`Issue #12

## Junit 5 tests pending
- [X] Controller tests
- [X] Service Tests
- [X] Repository Tests
- [ ] Entity tests (Possibly Dto integration?) Issue #22

## Continuous Integration/ Code coverage

- [x] Travis CI
- [x] codecov.io
- [x] Code Climate
- [x] SonarQube
- [x] Coveralls
