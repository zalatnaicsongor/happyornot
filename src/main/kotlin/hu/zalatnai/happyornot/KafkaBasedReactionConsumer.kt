package hu.zalatnai.happyornot

import mu.KotlinLogging
import org.springframework.cloud.stream.annotation.StreamListener

class KafkaBasedReactionConsumer(private val reactionStore: ReactionStore) {
    private val logger = KotlinLogging.logger {}

    @StreamListener(ReactionConsumerStream.INPUT)
    fun handle(reactionAsString: String) {
        logger.info("Consuming message " + reactionAsString)
        val reaction = when (reactionAsString) {
            "P" -> Reaction.Positive
            "N" -> Reaction.Negative
            else -> throw RuntimeException()
        }

        reactionStore.processReaction(reaction)
    }
}