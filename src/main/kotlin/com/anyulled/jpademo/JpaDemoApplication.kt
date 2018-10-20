package com.anyulled.jpademo

import io.sentry.spring.SentryExceptionResolver
import io.sentry.spring.SentryServletContextInitializer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.HandlerExceptionResolver

@SpringBootApplication
class JpaDemoApplication {
    @Bean
    fun sentryExceptionResolver(): HandlerExceptionResolver = SentryExceptionResolver()

    @Bean
    fun sentryServletContextInitializer(): ServletContextInitializer = SentryServletContextInitializer()

}

fun main(args: Array<String>) {
    runApplication<JpaDemoApplication>(*args)
}

