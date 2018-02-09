package hu.zalatnai.happyornot

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HappyOrNotConfiguration {
    @Bean
    fun inMemoryReactionPublisher() : InMemoryReactionPublisher {
        return InMemoryReactionPublisher(ReactionStore())
    }
}