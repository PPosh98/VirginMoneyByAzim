package com.example.virginmoneyappazim.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneyappazim.R
import com.example.virginmoneyappazim.adapters.RoomsAdapter
import com.example.virginmoneyappazim.databinding.FragmentRoomsBinding
import com.example.virginmoneyappazim.util.UiStateRooms
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : Fragment(R.layout.fragment_rooms) {
    private lateinit var binding: FragmentRoomsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel by lazy {
            ViewModelProvider(requireActivity())[RoomsViewModel::class.java]
        }
        binding = FragmentRoomsBinding.bind(view)

        binding.recyclerViewRooms.apply {
            layoutManager = LinearLayoutManager(context)
        }

        binding.sflRooms.setOnRefreshListener {
            viewModel.getRooms()
        }

        viewModel.getRooms()

        viewModel.roomDetails.observe(requireActivity()) { state ->
            when(state) {
                is UiStateRooms.Loading -> {
                    Log.i("API Response: ", "LOADING")
                    binding.sflRooms.isRefreshing = true
                }
                is UiStateRooms.Success -> {
                    binding.sflRooms.isRefreshing = false
                    binding.recyclerViewRooms.adapter = RoomsAdapter(requireContext(), state.roomsResponse)
                }
                is UiStateRooms.Error -> {
                    Log.i("API Response: ", "Error -> ${state.error}")
                }
            }
        }
    }
}