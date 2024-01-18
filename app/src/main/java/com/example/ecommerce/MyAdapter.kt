package com.example.ecommerce

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val productList: List<Product>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {

        val image: ShapeableImageView
        val title: TextView

        init {
            image= itemview.findViewById(R.id.imgProduct)
            title= itemview.findViewById(R.id.txtproductname)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemview = LayoutInflater.from(context).inflate(R.layout.one_item, parent, false)
        return MyViewHolder(itemview)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        val currentItem = productList[position]

        holder.title.text = currentItem.title
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
    }

    override fun getItemCount(): Int {
        return productList.size

    }
}