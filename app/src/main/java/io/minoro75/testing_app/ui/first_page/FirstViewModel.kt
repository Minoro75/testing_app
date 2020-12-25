package io.minoro75.testing_app.ui.first_page

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.minoro75.testing_app.ui.data.ResponseClass
import io.minoro75.testing_app.ui.data.ResponseClassItem
import io.minoro75.testing_app.ui.repo.NewsRepository
import io.minoro75.testing_app.ui.utils.NetworkUtils
import io.minoro75.testing_app.ui.utils.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

class FirstViewModel @ViewModelInject constructor(
    private val newsRepository: NewsRepository,
    networkUtils: NetworkUtils
) : ViewModel() {
    private val _newsList = MutableLiveData<Resource<ResponseClass>>()
    val newsList: LiveData<Resource<ResponseClass>> = _newsList

    init {
        _newsList.postValue(Resource.loading(null))

        if (networkUtils.isNetworkConnected()) {
            //check if we connected to wifi\cellular and then fetch data
            fetchNews()
        } else {
            _newsList.postValue(Resource.error(null, "internet error"))
        }
    }

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                _newsList.value =
                   Resource.success(data = newsRepository.getNewsRepo())
            } catch (ex: Exception) {
                _newsList.value = Resource.error(null, message = ex.localizedMessage?: "unexpected error")
            }
        }
    }
}