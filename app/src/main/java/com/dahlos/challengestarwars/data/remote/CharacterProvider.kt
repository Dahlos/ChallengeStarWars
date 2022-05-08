package com.dahlos.challengestarwars.data.remote

import com.dahlos.challengestarwars.data.model.Character
import com.dahlos.challengestarwars.data.model.CharacterList
import com.dahlos.challengestarwars.repository.WebService

class CharacterProvider(private val webService: WebService) {

    suspend fun getCharacters(): CharacterList = webService.getCharacters()

    suspend fun getCharacter(id: String): Character = webService.getCharacter(id)
}