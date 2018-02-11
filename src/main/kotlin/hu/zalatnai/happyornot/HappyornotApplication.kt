package hu.zalatnai.happyornot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class HappyornotApplication {
    @Bean
    fun reactionStore(): ReactionStore {
        return ReactionStore()
    }
}

fun main(args: Array<String>) {
    runApplication<HappyornotApplication>(*args)
}
