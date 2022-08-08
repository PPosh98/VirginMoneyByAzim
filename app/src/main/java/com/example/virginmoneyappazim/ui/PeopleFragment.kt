package com.example.virginmoneyappazim.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneyappazim.R
import com.example.virginmoneyappazim.adapters.PeopleAdapter
import com.example.virginmoneyappazim.databinding.FragmentPeopleBinding
import com.example.virginmoneyappazim.util.UiStatePeople
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment(R.layout.fragment_people) {
    private lateinit var binding: FragmentPeopleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel by lazy {
            ViewModelProvider(requireActivity())[PeopleViewModel::class.java]
        }
        binding = FragmentPeopleBinding.bind(view)

        binding.recyclerViewPeople.apply {
            layoutManager = LinearLayoutManager(context)
        }

        binding.sflPeople.setOnRefreshListener {
            viewModel.getPeople()
        }

        viewModel.getPeople()

        viewModel.peopleDetails.observe(requireActivity()) { state ->
            when(state) {
                is UiStatePeople.Loading -> {
                    Log.i("API Response: ", "LOADING")
                    binding.sflPeople.isRefreshing = true
                }
                is UiStatePeople.Success -> {
                    binding.sflPeople.isRefreshing = false
                    binding.recyclerViewPeople.adapter = PeopleAdapter(requireContext(), state.peopleResponse)
                }
                is UiStatePeople.Error -> {
                    Log.i("API Response: ", "Error -> ${state.error}")
                }
            }
        }
    }
}