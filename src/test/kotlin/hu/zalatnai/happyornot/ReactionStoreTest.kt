package hu.zalatnai.happyornot

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ReactionStoreTest {
    lateinit var reactionStore: ReactionStore

    @Before
    fun setUp() {
        reactionStore = ReactionStore()
    }

    @Test
    fun `a positive reaction increments the number of positive reactions and does not modify the negative reactions`() {
        reactionStore.processReaction(Reaction.Positive)

        assertEquals(1, reactionStore.positive)
        assertEquals(0, reactionStore.negative)
    }

    @Test
    fun `a negative reaction increments the number of negative reactions and does not modify the positive directions`() {
        reactionStore.processReaction(Reaction.Negative)

        assertEquals(0, reactionStore.positive)
        assertEquals(1, reactionStore.negative)
    }
}