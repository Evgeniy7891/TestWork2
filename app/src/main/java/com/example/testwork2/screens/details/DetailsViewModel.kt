package com.example.testwork2.screens.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testwork2.data.repository.Repository
import com.example.testwork2.model.details.DetailsItem
import com.example.testwork2.model.feedmodel.FeedModelState
import kotlinx.coroutines.launch


class DetailsViewModel : ViewModel() {

    var repository = Repository()
    val detailsList: MutableLiveData<DetailsItem> = MutableLiveData()
    val dataState: MutableLiveData<FeedModelState> = MutableLiveData()


    fun getCompany(id: Int) = viewModelScope.launch {
        try {
            detailsList.value = repository.getDetailsCompany(id).get(0)
            dataState.value = FeedModelState(loading = true)
        } catch (e: Exception) {
            dataState.value = FeedModelState(error = true)
        }
    }
}