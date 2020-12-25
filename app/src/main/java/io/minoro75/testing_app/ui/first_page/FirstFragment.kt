package io.minoro75.testing_app.ui.first_page

import android.os.Bundle
import android.provider.DocumentsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import io.minoro75.testing_app.R
import io.minoro75.testing_app.ui.data.ResponseClass
import io.minoro75.testing_app.ui.utils.Status
@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val firstViewModel: FirstViewModel by viewModels()
    private lateinit var adapter: FirstAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_first_page, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.rv_first_fragment)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = FirstAdapter(ResponseClass())
        recyclerView.adapter = adapter

        //observing livedata for news changes

        firstViewModel.newsList.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { news ->
                        renderList(news)
                    }

                }
                Status.ERROR -> {
                }
                Status.LOADING -> {
                }
            }
        })

        return root
    }

    private fun renderList(responseClass: ResponseClass) {
        adapter.addNews(responseClass)
        adapter.notifyDataSetChanged()
    }
}