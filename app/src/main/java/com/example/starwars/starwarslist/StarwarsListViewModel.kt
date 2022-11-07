package com.example.starwars.starwarslist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwars.data.models.StarwarsListEntry
import com.example.starwars.repository.StarwarsRepository
import com.example.starwars.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarwarsListViewModel @Inject constructor(
    private val repository: StarwarsRepository
)  : ViewModel() {

    //starwarslist
    var starwarsCategory = mutableStateOf<List<StarwarsListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    val categoryName = listOf("Films", "People", "Planets", "Species", "Starships", "Vehicles")


    init {
        loadStarwarsPaginated()
    }

    fun loadStarwarsPaginated() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getCategoryList()
            val films = result.data?.films
            val people = result.data?.people
            val planets = result.data?.planets
            val species = result.data?.species
            val starships = result.data?.starships
            val vehicles = result.data?.vehicles
            val categoryUrl = listOf(films, people, people, planets, species, starships, vehicles)
            when(result) {
                is Resource.Success -> {
                    val entries : MutableState<List<StarwarsListEntry>> = mutableStateOf(listOf())
                    for (i in categoryName.indices) {
                       entries.value += StarwarsListEntry(categoryName[i], categoryUrl[i]!!)
                    }
                    loadError.value = ""
                    isLoading.value = false
                    starwarsCategory.value += entries.value

                }
                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }

            }
        }
    }
    //calcDominantColor


}