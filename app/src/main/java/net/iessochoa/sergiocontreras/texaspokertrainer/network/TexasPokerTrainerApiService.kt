package net.iessochoa.sergiocontreras.texaspokertrainer.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface TexasPokerTrainerApiService {

    @GET("deck/new")
    suspend fun createDeck(): DeckDto

    @GET("deck/{deckId}/draw/?count={cardsCount}")
    suspend fun drawCards(@Path("deckId") deckId: String, @Query("cardsCount") cardsCount: Int): DrawResponseDto

}