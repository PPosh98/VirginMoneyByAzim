package com.example.virginmoneyappazim.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoneyappazim.R
import com.example.virginmoneyappazim.databinding.ListItemPersonBinding
import com.example.virginmoneyappazim.databinding.ListItemRoomBinding
import com.example.virginmoneyappazim.model.people.PeopleItemModel
import com.example.virginmoneyappazim.model.rooms.Rooms
import com.example.virginmoneyappazim.model.rooms.RoomsItemModel

class RoomsAdapter(val context: Context, val roomsList: Rooms) : RecyclerView.Adapter<RoomsAdapter.RoomsViewHolder>() {

    class RoomsViewHolder(roomItem: View) : RecyclerView.ViewHolder(roomItem) {
        val binding = ListItemRoomBinding.bind(roomItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RoomsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_room, parent, false)
    )

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        holder.binding.tvRoomNumber.text = "Room: ${roomsList[position].id}"
        holder.binding.tvRoomIsOccupied.text = "Occupied: ${if (roomsList[position].isOccupied) "Yes" else "No"}"
        holder.binding.tvRoomMaxOccupancy.text = "Max Occupancy: ${roomsList[position].maxOccupancy}"
    }

    override fun getItemCount() = roomsList.size

}