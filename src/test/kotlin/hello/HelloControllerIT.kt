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

    private var base: URL? = null

    @Autowired
    private val template: TestRestTemplate? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        this.base = URL("http://localhost:$port/")
    }

    @Test
    fun getHello() {
        val response = template!!.getForEntity(base!!.toString(),
                String::class.java)
        Assert.assertThat(response.body, Matchers.equalTo("Greetings from Spring Boot!"))
    }
}