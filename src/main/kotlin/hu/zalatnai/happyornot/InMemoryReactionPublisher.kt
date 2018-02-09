package hu.zalatnai.happyornot

class InMemoryReactionPublisher(private val reactionStore: ReactionStore) : ReactionPublisher {
    override fun publish(reaction: Reaction) {
        reactionStore.processReaction(reaction)
    }
}