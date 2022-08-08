package com.example.virginmoneyappazim.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.virginmoneyappazim.R
import com.example.virginmoneyappazim.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_details) {
    val myData_list = requireArguments().get("user_details") as ArrayList<String>

    private lateinit var binding: FragmentDetailsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
        binding.tvPersonFirstName.text = myData_list[1]
        binding.tvPersonLastName.text = myData_list[2]
        binding.tvJobtitle.text = myData_list[0]
        binding.tvEmail.text = myData_list[4]
        Glide
            .with(requireActivity())
            .load(myData_list[3])
            .into(binding.ivPersonImage)
    }
}