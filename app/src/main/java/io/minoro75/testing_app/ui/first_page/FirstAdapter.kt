package io.minoro75.testing_app.ui.first_page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.minoro75.testing_app.R
import io.minoro75.testing_app.ui.data.ResponseClass
import io.minoro75.testing_app.ui.data.ResponseClassItem

class FirstAdapter(
    private val newsList: ResponseClass
) : RecyclerView.Adapter<FirstAdapter.FirstViewHolder>() {

    class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(responseClassItem: ResponseClassItem) {
            itemView.findViewById<TextView>(R.id.tv_first_page_title).text =
                responseClassItem.title.rendered
            //itemView.findViewById<ImageView>(R.id.iv_first_page)
            //ToDo: add a Glide img load
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder =
        FirstViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_first_page_item, parent, false
            )
        )


    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) =
        holder.bind(newsList[position])

    override fun getItemCount(): Int =
        newsList.size

    fun addNews(list: ResponseClass) {
        newsList.addAll(list)
    }
}


