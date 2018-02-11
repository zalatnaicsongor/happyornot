package hu.zalatnai.happyornot

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel

interface ReactionPublisherStream {
    companion object {
        const val OUTPUT = "reactionOutput"
    }

    @Output(ReactionPublisherStream.OUTPUT)
    fun reactionOutput(): MessageChannel
}