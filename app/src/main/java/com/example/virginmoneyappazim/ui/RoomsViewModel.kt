package com.example.virginmoneyappazim.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoneyappazim.model.people.People
import com.example.virginmoneyappazim.model.people.PeopleItemModel
import com.example.virginmoneyappazim.model.rooms.Rooms
import com.example.virginmoneyappazim.model.rooms.RoomsItemModel
import com.example.virginmoneyappazim.repository.Repository
import com.example.virginmoneyappazim.util.UiStatePeople
import com.example.virginmoneyappazim.util.UiStateRooms
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RoomsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _roomDetails: MutableLiveData<UiStateRooms> = MutableLiveData(UiStateRooms.Loading)
    val roomDetails: LiveData<UiStateRooms> get() = _roomDetails

    fun getRooms() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getRooms()

            if (response.isSuccessful) {
                _roomDetails.postValue(
                    response.body()?.let { success ->
                        UiStateRooms.Success(
                            response.body() as Rooms
                        )
                    }
                )
            } else {
                _roomDetails.postValue(
                    UiStateRooms.Error(
                        Throwable(
                            response.message()
                        )
                    )
                )
            }
        }
    }
}