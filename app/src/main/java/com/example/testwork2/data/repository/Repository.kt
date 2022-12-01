package com.example.testwork2.data.repository

import com.example.testwork2.data.api.RetrofitInstance
import com.example.testwork2.error.ApiError
import com.example.testwork2.error.UnknowError
import com.example.testwork2.model.company.CompanyItem
import com.example.testwork2.model.details.DetailsItem
import java.io.IOException

class Repository {

    suspend fun getCompany(): List<CompanyItem> {
        try {
            val response = RetrofitInstance.api.getCompany()
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val body = response.body()?.map {
                it.copy(img = "https://lifehack.studio/test_task/${it.img}")
            } ?: throw  ApiError(response.code(), response.message())
            return body
        } catch (e: IOException) {
            return emptyList()
        } catch (e: Exception) {
            throw UnknowError
        }
    }


    suspend fun getDetailsCompany(id: Int): List<DetailsItem> {
        try {
            val response = RetrofitInstance.api.getDetailsCompany(id)
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val body = response.body() ?: throw  ApiError(response.code(), response.message())
            return body
        } catch (e: IOException) {
            return emptyList()
        } catch (e: Exception) {
            throw UnknowError
        }
    }
}