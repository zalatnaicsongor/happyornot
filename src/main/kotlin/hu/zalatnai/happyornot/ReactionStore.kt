package hu.zalatnai.happyornot

open class ReactionStore {

    var positive: Int = 0
        private set

    var negative: Int = 0
        private set

    open fun processReaction(reaction: Reaction) {
        when(reaction) {
            is Reaction.Negative -> negative += 1
            is Reaction.Positive -> positive += 1
        }
    }
}