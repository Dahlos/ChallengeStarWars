package com.dahlos.challengestarwars.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.dahlos.challengestarwars.core.Result
import com.dahlos.challengestarwars.data.model.Character
import com.dahlos.challengestarwars.data.model.CharacterList
import com.dahlos.challengestarwars.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class CharacterViewModel(private val repository: CharacterRepository) :
    ViewModel() {
    // livedata to hold the list of characters
    val characters = MutableLiveData<CharacterList>()
    val character = MutableLiveData<Character>()

    fun getCharacters() = liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            val result = repository.getCharacters()
            emit(Result.Success(result))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

    fun getCharacter(id: Int) {
        //val character = CharacterRepository.getCharacter(id)
        //characters.value = character
    }
}

class CharacterViewModelFactory(private val repository: CharacterRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CharacterRepository::class.java).newInstance(repository)
    }
}
