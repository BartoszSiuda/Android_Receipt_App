package com.example.android_receipt_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.single_receipt.view.*


class ListAdapter (private val context: Context?) : RecyclerView.Adapter<ViewHolder>() {

    private var receiptsList: List<ReceiptEntity> = ArrayList()

    fun setPosts(newPostsList: List<ReceiptEntity>) {
        this.receiptsList = newPostsList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int { return receiptsList.size }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_receipt, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Prepare fetched data
        val title = receiptsList[position].title
        val image = receiptsList[position].image
        val description = receiptsList[position].description

        // Set data within the holder
        holder.titleXml.text = title
        // Todo: Add image.
        holder.descriptionXml.text = description

    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val titleXml = view.receipt_title
    val imageXml = view.image_of_nalesniki
    val descriptionXml = view.description_receipt
}