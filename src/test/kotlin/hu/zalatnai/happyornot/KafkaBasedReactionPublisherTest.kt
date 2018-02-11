package hu.zalatnai.happyornot

import com.nhaarman.mockito_kotlin.argWhere
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel

@RunWith(MockitoJUnitRunner::class)
class KafkaBasedReactionPublisherTest {

    lateinit var kafkaBasedReactionPublisher: KafkaBasedReactionPublisher

    @Mock
    lateinit var reactionPublisherStream: ReactionPublisherStream

    @Mock
    lateinit var messageChannel: MessageChannel

    @Before
    fun setUp() {
        kafkaBasedReactionPublisher = KafkaBasedReactionPublisher(reactionPublisherStream)
        whenever(reactionPublisherStream.reactionOutput()).thenReturn(messageChannel)
    }

    @Test
    fun `when the reaction is postitve the value "P" is sent to the message channel`() {
        kafkaBasedReactionPublisher.publish(Reaction.Positive)
        verify(messageChannel).send(argWhere<Message<String>> { it.payload == "P" })
    }

    @Test
    fun `when the reaction is negative the value "N" is sent to the message channel`() {
        kafkaBasedReactionPublisher.publish(Reaction.Negative)
        verify(messageChannel).send(argWhere<Message<String>> { it.payload == "N" })
    }
}