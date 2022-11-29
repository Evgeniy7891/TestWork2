package com.example.testwork2.data.api

import com.example.testwork2.model.company.Company
import com.example.testwork2.model.details.Details
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("test.php")
    suspend fun getCompany(): Response<Company>

    @GET("test.php")
    suspend fun getDetailsCompany(@Query("id") id: Int): Response<Details>
}