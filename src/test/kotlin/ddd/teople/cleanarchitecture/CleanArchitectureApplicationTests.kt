package ddd.teople.cleanarchitecture

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * 비지니스로직과 테스트로직을 분리하기 위해 별도의 Runner Class 사용
 */
@SpringBootApplication
class CleanArchitectureApplicationTests {

    fun main(args: Array<String>) {
        runApplication<CleanArchitectureApplicationTests>(*args)
    }

}
