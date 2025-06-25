package com.mehru.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class NewsAdapter(private val newsArrayList:ArrayList<News>, var context : Activity) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsAdapter.MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.each_item,p0,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(p0: NewsAdapter.MyViewHolder, p1: Int) {
        val currentItem = newsArrayList[p1]
        p0.newsTv.text = currentItem.newsHeading
        p0.newsImag.setImageResource(currentItem.newsImage)
    }

    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsImag = itemView.findViewById<ShapeableImageView>(R.id.newsImage)
        val newsTv  = itemView.findViewById<TextView>(R.id.newsTv)
    }

}
