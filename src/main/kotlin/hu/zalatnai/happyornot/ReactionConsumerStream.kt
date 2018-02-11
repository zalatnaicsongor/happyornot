package hu.zalatnai.happyornot

import org.springframework.cloud.stream.annotation.Input
import org.springframework.messaging.SubscribableChannel

interface ReactionConsumerStream {
    companion object {
        const val INPUT = "reactionInput"
    }

    @Input(ReactionConsumerStream.INPUT)
    fun reactionInput(): SubscribableChannel
}