package com.example.testwork2.screens.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testwork2.data.repository.Repository
import com.example.testwork2.model.company.CompanyItem
import com.example.testwork2.model.details.Details
import com.example.testwork2.model.details.DetailsItem
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    var repository = Repository()
    val detailsList : MutableLiveData<List<DetailsItem>> = MutableLiveData()

    fun getCompany(id: Int) {
        viewModelScope.launch {
            detailsList.value = repository.getDetailsCompany(id)
        }
    }
}