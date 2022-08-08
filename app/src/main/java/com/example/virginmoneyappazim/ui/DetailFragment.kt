package com.example.virginmoneyappazim.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.virginmoneyappazim.R
import com.example.virginmoneyappazim.databinding.FragmentPeopleBinding
import com.example.virginmoneyappazim.databinding.ItemDetailsPersonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.item_details_person) {
    val myData_list = requireArguments().get("user_details") as ArrayList<String>

    private lateinit var binding: ItemDetailsPersonBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding
    }
}