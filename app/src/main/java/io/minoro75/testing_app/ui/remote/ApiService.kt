package io.minoro75.testing_app.ui.remote

import io.minoro75.testing_app.ui.data.ResponseClass
import io.minoro75.testing_app.ui.data.ResponseClassItem
import retrofit2.http.GET

interface ApiService {
@GET(RestConfig.API_NEWS_CALL)
suspend fun getNews():ResponseClassItem

}