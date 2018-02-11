package hu.zalatnai.happyornot

import org.springframework.context.annotation.Profile
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Profile("kafka")
@Service
class KafkaBasedReactionPublisher(private val reactionPublisherStream: ReactionPublisherStream) : ReactionPublisher {
    override fun publish(reaction: Reaction) {
        val payload = when (reaction) {
            Reaction.Positive -> "P"
            Reaction.Negative -> "N"
        }
        reactionPublisherStream.reactionOutput().send(MessageBuilder.withPayload(payload).build())
    }
}