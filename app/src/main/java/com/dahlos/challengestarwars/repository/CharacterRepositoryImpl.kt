package com.dahlos.challengestarwars.repository

import com.dahlos.challengestarwars.data.model.Character
import com.dahlos.challengestarwars.data.model.CharacterList
import com.dahlos.challengestarwars.data.remote.CharacterProvider

class CharacterRepositoryImpl(private val characterProvider: CharacterProvider) :
    CharacterRepository {
    override suspend fun getCharacter(id: String): Character = characterProvider.getCharacter(id)
    override suspend fun getCharacters(): CharacterList = characterProvider.getCharacters()

}