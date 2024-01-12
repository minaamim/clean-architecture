package ddd.teople.cleanarchitecture

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@EnableCaching
@SpringBootApplication
class CleanArchitectureApplication

fun main(args: Array<String>) {
    runApplication<CleanArchitectureApplication>(*args)
}
