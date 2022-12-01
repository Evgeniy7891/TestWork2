package com.example.testwork2.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testwork2.data.repository.Repository
import com.example.testwork2.model.company.CompanyItem
import com.example.testwork2.model.feedmodel.FeedModelState
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var repository = Repository()
    val companyList: MutableLiveData<List<CompanyItem>> = MutableLiveData()
    val dataState: MutableLiveData<FeedModelState> = MutableLiveData()

    fun getCompany() = viewModelScope.launch {
        try {
            companyList.value = repository.getCompany()
            dataState.value = FeedModelState(loading = true)
        } catch (e: Exception) {
            dataState.value = FeedModelState(error = true)
        }
    }
}
