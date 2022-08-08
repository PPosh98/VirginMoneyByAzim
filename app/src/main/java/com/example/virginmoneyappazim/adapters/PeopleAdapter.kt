package com.example.virginmoneyappazim.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoneyappazim.R
import com.example.virginmoneyappazim.databinding.ListItemPersonBinding
import com.example.virginmoneyappazim.model.people.People
import com.example.virginmoneyappazim.model.people.PeopleItemModel

class PeopleAdapter(val context: Context, val peopleList: People) : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    class PeopleViewHolder(personItem: View) : RecyclerView.ViewHolder(personItem) {
        val binding = ListItemPersonBinding.bind(personItem)
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
        holder.itemView.setOnClickListener() {
            val myList = mutableListOf<String>(
                peopleList[position].jobtitle,
                peopleList[position].firstName,
                peopleList[position].lastName,
                peopleList[position].avatar,
                peopleList[position].email,
                peopleList[position].favouriteColor,
                peopleList[position].id
            )

            val bundle = Bundle()
            bundle.putStringArrayList("user_details",myList as ArrayList<String>)

            it.findNavController().navigate(R.id.action_peopleFragment_to_detailFragment, bundle)
        }
    }

    override fun getItemCount() = peopleList.size

}