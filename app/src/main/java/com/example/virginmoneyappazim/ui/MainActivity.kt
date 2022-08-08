package com.example.virginmoneyappazim.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.virginmoneyappazim.R
import com.example.virginmoneyappazim.adapters.ViewPagerAdapter
import com.example.virginmoneyappazim.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val myViewPager: ViewPager2 = binding.viewPager
        val myTabLayout: TabLayout = binding.tabLayout

        val texts = listOf("People", "Rooms")
        val mAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        myViewPager.adapter = mAdapter

        TabLayoutMediator(myTabLayout,myViewPager){tab,position->

            when{
                position == 0 -> tab.text = texts[position]
                position == 1 -> tab.text = texts[position]
            }

        }.attach()

        setContentView(binding.root)
    }
}