package hu.zalatnai.happyornot

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HappyOrNotController(val reactionPublisher: ReactionPublisher) {
    @PostMapping("/positive")
    fun positiveReaction() {
        reactionPublisher.publish(Reaction.Positive)
    }

    @PostMapping("/negative")
    fun negativeReaction() {
        reactionPublisher.publish(Reaction.Negative)
    }
}