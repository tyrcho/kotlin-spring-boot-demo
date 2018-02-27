package hello

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class HelloApp {

    @Bean
    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner =
            CommandLineRunner { _ ->
                println("Let's inspect the beans provided by Spring Boot:")

                val beanNames = ctx.beanDefinitionNames
                Arrays.sort(beanNames)
                for (beanName in beanNames) {
                    println(beanName)
                }
            }

}

fun main(args: Array<String>) {
    SpringApplication.run(HelloApp::class.java, *args)
}