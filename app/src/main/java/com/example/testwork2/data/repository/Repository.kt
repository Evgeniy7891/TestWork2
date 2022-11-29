package com.example.testwork2.data.repository

import com.example.testwork2.data.api.RetrofitInstance
import com.example.testwork2.model.company.Company
import com.example.testwork2.model.company.CompanyItem
import com.example.testwork2.model.details.DetailsItem
import retrofit2.Response

class Repository {
    suspend fun getCompany(): List<CompanyItem> {
        return RetrofitInstance.api.getCompany().body()!!.map {
            it.copy(img = "https://lifehack.studio/test_task/${it.img}")
        }
    }
    suspend fun getDetailsCompany(id:Int) : List<DetailsItem> {
        return RetrofitInstance.api.getDetailsCompany(id).body()!!.map {
            it.copy(img = "https://lifehack.studio/test_task/${it.img}")
        }
    }
}