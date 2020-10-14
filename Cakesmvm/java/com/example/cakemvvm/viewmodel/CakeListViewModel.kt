package com.example.cakemvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cakemvvm.repository.CakeRepository
import kotlinx.coroutines.*
import java.lang.Exception

class CakeListViewModel (private val cakeRepository: CakeRepository): ViewModel() {
    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val cakeListResults = cakeRepository.results

    init {
        refreshFromRepository()
    }

    fun refreshFromRepository(){
        viewModelScope.launch {
            try {
                cakeRepository.refreshCakes()

            }
            catch (networkError: Exception){}
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}