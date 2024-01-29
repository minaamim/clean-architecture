package feature

import ddd.teople.cleanarchitecture.CleanArchitectureApplicationTests
import io.cucumber.spring.CucumberContextConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [CleanArchitectureApplicationTests::class])
@CucumberContextConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SpringIntegrationTest