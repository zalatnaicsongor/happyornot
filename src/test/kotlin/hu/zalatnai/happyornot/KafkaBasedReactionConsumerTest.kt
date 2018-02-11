package hu.zalatnai.happyornot

import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class KafkaBasedReactionConsumerTest {

    lateinit var kafkaBasedReactionConsumer: KafkaBasedReactionConsumer

    @Mock
    lateinit var reactionStore: ReactionStore

    @Before
    fun setUp() {
        kafkaBasedReactionConsumer = KafkaBasedReactionConsumer(reactionStore)
    }

    @Test
    fun `when the input is P then a positive reaction event is sent to the store`() {
        kafkaBasedReactionConsumer.handle("P")

        verify(reactionStore).processReaction(Reaction.Positive)
    }

    @Test
    fun `when the input is N then a negative reaction event is sent to the store`() {
        kafkaBasedReactionConsumer.handle("N")

        verify(reactionStore).processReaction(Reaction.Negative)
    }

    @Test(expected = RuntimeException::class)
    fun `when the input is anything else then an exception is thrown`() {
        kafkaBasedReactionConsumer.handle("Hello")
    }
}