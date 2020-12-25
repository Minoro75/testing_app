package io.minoro75.testing_app.ui.remote

import io.minoro75.testing_app.ui.data.ResponseClass
import javax.inject.Inject

class ApiServiceHelperImpl @Inject constructor(
private val apiService : ApiService
) :ApiServiceHelper {
    override suspend fun getNews(): ResponseClass {
return apiService.getNews()
    }
}