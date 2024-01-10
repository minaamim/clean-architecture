package ddd.teople.cleanarchitecture

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@SpringBootApplication
class CleanArchitectureApplication

fun main(args: Array<String>) {
    runApplication<CleanArchitectureApplication>(*args)
}
