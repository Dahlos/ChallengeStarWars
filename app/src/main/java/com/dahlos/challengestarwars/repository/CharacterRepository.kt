package com.dahlos.challengestarwars.repository

import com.dahlos.challengestarwars.data.model.Character
import com.dahlos.challengestarwars.data.model.CharacterList

interface CharacterRepository {
    suspend fun getCharacter(id:String): Character
    suspend fun getCharacters(): CharacterList
}