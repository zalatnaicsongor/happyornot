package hu.zalatnai.happyornot

class ReactionStore {

    var positive: Int = 0
        private set

    var negative: Int = 0
        private set

    fun processReaction(reaction: Reaction) {
        when(reaction) {
            Reaction.Negative -> negative += 1
            Reaction.Positive -> positive += 1
        }
    }
}