package hu.zalatnai.happyornot

sealed class Reaction {
    object Positive : Reaction()
    object Negative : Reaction()
}