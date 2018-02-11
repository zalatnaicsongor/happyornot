package hu.zalatnai.happyornot

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("local")
class HappyOrNotLocalConfiguration {
    @Bean
    fun inMemoryReactionPublisher() : InMemoryReactionPublisher {
        return InMemoryReactionPublisher(ReactionStore())
    }
}