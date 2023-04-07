package com.example.fetchdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FetchAdapter(var context: Context, var data: ArrayList<Datamodel>) :
    RecyclerView.Adapter<FetchAdapter.ViewHolderFetch>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFetch {
        var view =LayoutInflater.from(context).inflate(R.layout.itemlayout,parent,false)
        var viewholder = ViewHolderFetch(view)
        return viewholder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolderFetch, position: Int) {
        Glide.with(context).load(data.get(position).profileImage).into(holder.profileimage)
        holder.username.text = data.get(position).username
        holder.email.text = data.get(position).email
    }

    class ViewHolderFetch(itemview: View):RecyclerView.ViewHolder(itemview){
        var profileimage = itemview.findViewById<ImageView>(R.id.profileImage)
        var username = itemview.findViewById<TextView>(R.id.usernametxt)
        var email = itemview.findViewById<TextView>(R.id.emailtxt)
    }

}