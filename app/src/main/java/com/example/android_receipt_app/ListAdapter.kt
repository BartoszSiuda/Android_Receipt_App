package com.example.android_receipt_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.main_feed_list_item.view.*

// Main adapter used for managing items list within the main RecyPostDatabaseEntityclerView (main feed listed)
class ListAdapter (private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private var receiptsList: List<ReceiptEntity> = ArrayList()

    fun setPosts(newPostsList: List<ReceiptEntity>) {
        this.receiptsList = newPostsList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int { return receiptsList.size }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.single_receipt, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Prepare fetched data
        val title = receiptsList[position].title
//        val author = receiptsList[position].author
//        val urlToImage = receiptsList[position].thumbnail

        // Set data within the holder
//        holder.title.text = title
//        holder.author.text = author
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
//    val picture = view.imageView_picture
//    val title = view.greenbackgroundtext
//    val author = view.textView_author
//    val rowContainer = view.row_container
}