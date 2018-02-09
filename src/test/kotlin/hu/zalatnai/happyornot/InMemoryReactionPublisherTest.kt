package hu.zalatnai.happyornot

import com.nhaarman.mockito_kotlin.argWhere
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InMemoryReactionPublisherTest {

    @Mock
    lateinit var reactionStore: ReactionStore

    lateinit var inMemoryReactionPublisher: InMemoryReactionPublisher

    @Before
    fun setUp() {
        inMemoryReactionPublisher = InMemoryReactionPublisher(reactionStore)
    }

    @Test
    fun `forwards the reaction to the store`() {
        inMemoryReactionPublisher.publish(Reaction.Positive)
        verify(reactionStore).processReaction(argWhere { it is Reaction.Positive })
    }
}