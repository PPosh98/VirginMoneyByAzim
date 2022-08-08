package com.example.virginmoneyappazim.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoneyappazim.model.people.People
import com.example.virginmoneyappazim.model.people.PeopleItemModel
import com.example.virginmoneyappazim.repository.Repository
import com.example.virginmoneyappazim.util.UiStatePeople
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _peopleDetails: MutableLiveData<UiStatePeople> =
        MutableLiveData(UiStatePeople.Loading)
    val peopleDetails: LiveData<UiStatePeople> get() = _peopleDetails

    fun getPeople() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPeople()

            if (response.isSuccessful) {
                _peopleDetails.postValue(
                    response.body()?.let { success ->
                        UiStatePeople.Success(
                            response.body() as People
                        )
                    }
                )
            } else {
                _peopleDetails.postValue(
                    UiStatePeople.Error(
                        Throwable(
                            response.message()
                        )
                    )
                )
            }
        }
    }
}