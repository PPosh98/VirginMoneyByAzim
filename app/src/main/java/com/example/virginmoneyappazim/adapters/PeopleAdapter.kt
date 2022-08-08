package com.example.virginmoneyappazim.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoneyappazim.R
import com.example.virginmoneyappazim.databinding.ListItemPersonBinding
import com.example.virginmoneyappazim.model.people.People
import com.example.virginmoneyappazim.model.people.PeopleItemModel

class PeopleAdapter(val context: Context, val peopleList: People) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    class PeopleViewHolder(musicItem: View) : RecyclerView.ViewHolder(musicItem) {
        val binding = ListItemPersonBinding.bind(musicItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PeopleViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_person, parent, false)
    )

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        //using glide library to load image into imageview
        Glide
            .with(context)
            .load(peopleList[position].avatar)
            .into(holder.binding.ivPersonImage)
        holder.binding.tvPersonFirstName.text = peopleList[position].firstName
        holder.binding.tvPersonLastName.text = peopleList[position].lastName
    }

    override fun getItemCount() = peopleList.size

}