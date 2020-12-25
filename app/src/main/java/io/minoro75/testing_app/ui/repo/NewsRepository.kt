package io.minoro75.testing_app.ui.repo

import io.minoro75.testing_app.ui.data.ResponseClassItem
import io.minoro75.testing_app.ui.remote.ApiServiceHelper
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiServiceHelper: ApiServiceHelper
) {
    suspend fun getNewsRepo(): ResponseClassItem {
        return apiServiceHelper.getNews()
    }
}