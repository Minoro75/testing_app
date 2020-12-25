package io.minoro75.testing_app.ui.remote

import io.minoro75.testing_app.ui.data.ResponseClass
import io.minoro75.testing_app.ui.data.ResponseClassItem

interface ApiServiceHelper {
suspend fun getNews(): ResponseClass
}