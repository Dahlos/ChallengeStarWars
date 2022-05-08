package com.dahlos.challengestarwars.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.dahlos.challengestarwars.core.Result
import com.dahlos.challengestarwars.core.RetrofitClient
import com.dahlos.challengestarwars.data.remote.CharacterProvider
import com.dahlos.challengestarwars.databinding.ActivityMainBinding
import com.dahlos.challengestarwars.presentation.viewmodel.CharacterViewModel
import com.dahlos.challengestarwars.presentation.viewmodel.CharacterViewModelFactory
import com.dahlos.challengestarwars.repository.CharacterRepositoryImpl

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<CharacterViewModel> {
        CharacterViewModelFactory(
            CharacterRepositoryImpl(
                CharacterProvider(RetrofitClient.webService)
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getCharacters().observe(this, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    Log.v("MainActivity Loading", "Loading")
                }
                is Result.Success -> {
                    Log.v("MainActivity Success", result.data.results[0].name)
                }
                is Result.Failure -> {
                    Log.v("MainActivity Failure", "${result.exception}")
                }
            }
        })
    }
}