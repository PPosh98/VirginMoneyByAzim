package com.example.virginmoneyappazim.ui

import androidx.lifecycle.ViewModel
import com.example.virginmoneyappazim.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: Repository) : ViewModel() {
    fun getPeople() {
        repository.getPeople()
    }
}