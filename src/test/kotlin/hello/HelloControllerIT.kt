package hello

import org.hamcrest.Matchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner
import java.net.URL

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIT {

    @LocalServerPort
    private val port: Int = 0

    private lateinit var base: URL

    @Autowired
    private lateinit var template: TestRestTemplate

    @Before
    fun setUp() {
        this.base = URL("http://localhost:$port/greeting")
    }

    @Test
    fun getHello() {
        val response = template.getForEntity(base.toString(), String::class.java)
        Assert.assertThat(response.body, Matchers.equalTo("{\"id\":1,\"content\":\"Hello, World\"}"))
    }
}