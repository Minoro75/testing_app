package io.minoro75.testing_app.ui.repo

import io.minoro75.testing_app.ui.data.ResponseClass
import io.minoro75.testing_app.ui.remote.ApiServiceHelper
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiServiceHelper: ApiServiceHelper
) {
    suspend fun getNewsRepo(): ResponseClass {
        return apiServiceHelper.getNews()
    }
}