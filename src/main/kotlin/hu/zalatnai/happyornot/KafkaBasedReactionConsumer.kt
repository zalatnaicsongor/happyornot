package hu.zalatnai.happyornot

import org.springframework.cloud.stream.annotation.StreamListener

class KafkaBasedReactionConsumer(private val reactionStore: ReactionStore) {

    @StreamListener(ReactionPublisherStream.INPUT)
    fun handle(reactionAsString: String) {
        val reaction = when (reactionAsString) {
            "P" -> Reaction.Positive
            "N" -> Reaction.Negative
            else -> throw RuntimeException()
        }

        reactionStore.processReaction(reaction)
    }
}