package hello

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class HelloApp

fun main(args: Array<String>) {
    SpringApplication.run(HelloApp::class.java, *args)
}
