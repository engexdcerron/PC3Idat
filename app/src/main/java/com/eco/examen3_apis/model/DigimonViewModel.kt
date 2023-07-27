package com.eco.examen3_apis.model

import androidx.lifecycle.*
import com.eco.examen3_apis.repository.DigimonRepository
import kotlinx.coroutines.launch


class DigimonViewModel : ViewModel() {
    private val repository = DigimonRepository()
    private val _digimonCards = MutableLiveData<List<DigimonCard>>()
    val digimonCards: LiveData<List<DigimonCard>> = _digimonCards
    val firstCard: LiveData<DigimonCard> = Transformations.map(_digimonCards) { cards ->
        cards.firstOrNull()
    }

    init {
        viewModelScope.launch {
            _digimonCards.value = repository.getAllCards()
        }
    }
}

