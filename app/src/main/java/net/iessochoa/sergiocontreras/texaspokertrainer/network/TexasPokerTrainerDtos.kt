package net.iessochoa.sergiocontreras.texaspokertrainer.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeckDto(
    val success: Boolean,
    @SerialName("deck_id") val deckId: String,
    val shuffled: Boolean,
    @SerialName("remaining") val remainingCards: Int
)

//https://www.deckofcardsapi.com/api/deck/new/
//https://www.deckofcardsapi.com/api/deck/<<deck_id>>/draw/?count=2

@Serializable
data class DrawResponseDto(
    val success: Boolean,
    @SerialName(value = "deck_id") val deckId: String,
    val cards: List<CardDto>,
    @SerialName("remaining") val remainingCards: Int
)

@Serializable
data class CardDto(
    val code: String,
    @SerialName(value="image") val imageUrl: String,
    val value: String,
    val suit: String
)