package hu.zalatnai.happyornot

import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("kafka")
@EnableBinding(value= [(ReactionPublisherStream::class), (ReactionConsumerStream::class)])
class HappyOrNotKafkaConfiguration {
    @Bean
    fun kafkaBasedReactionConsumer(reactionStore: ReactionStore): KafkaBasedReactionConsumer {
        return KafkaBasedReactionConsumer(reactionStore)
    }
}