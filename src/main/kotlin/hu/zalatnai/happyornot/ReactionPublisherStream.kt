package hu.zalatnai.happyornot

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.context.annotation.Profile
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel

interface ReactionPublisherStream {
    companion object {
        const val OUTPUT = "reactionOutput"
        const val INPUT = "reactionInput"
    }

    @Output(ReactionPublisherStream.OUTPUT)
    fun reactionOutput(): MessageChannel

    @Input(ReactionPublisherStream.INPUT)
    fun reactionInput(): SubscribableChannel
}