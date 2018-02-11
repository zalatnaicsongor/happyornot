package hu.zalatnai.happyornot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HappyOrNotController(private val reactionPublisher: ReactionPublisher, private val reactionStore: ReactionStore) {
    @PostMapping("/positive")
    fun positiveReaction() {
        reactionPublisher.publish(Reaction.Positive)
    }

    @PostMapping("/negative")
    fun negativeReaction() {
        reactionPublisher.publish(Reaction.Negative)
    }

    @GetMapping("/reactions")
    fun reactions(): ReactionOutput {
        return ReactionOutput(reactionStore.positive, reactionStore.negative)
    }
}

data class ReactionOutput(val positive: Int, val negative: Int)