package com.example.testwork2.screens.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testwork2.data.repository.Repository
import com.example.testwork2.model.company.CompanyItem
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    var repository = Repository()
    val companyList : MutableLiveData<List<CompanyItem>> = MutableLiveData()

   fun getCompany() {
        viewModelScope.launch {
            companyList.value = repository.getCompany()
        }
    }
}