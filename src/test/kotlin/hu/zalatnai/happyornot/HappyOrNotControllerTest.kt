package hu.zalatnai.happyornot

import com.nhaarman.mockito_kotlin.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HappyOrNotControllerTest {
    @Mock
    lateinit var reactionPublisher: ReactionPublisher

    lateinit var happyOrNotController: HappyOrNotController

    @Before
    fun setUp() {
        happyOrNotController = HappyOrNotController(reactionPublisher)
    }

    @Test
    fun `when publishing a positive reaction the publisher is instructed to publish a positive reaction message`() {
        happyOrNotController.positiveReaction()
        verify(reactionPublisher).publish(argWhere { it is Reaction.Positive })
    }

    @Test
    fun `when publishing a negative reaction the publisher is instructed to publish a negative reaction message`() {
        happyOrNotController.negativeReaction()
        verify(reactionPublisher).publish(argWhere { it is Reaction.Negative })
    }
}