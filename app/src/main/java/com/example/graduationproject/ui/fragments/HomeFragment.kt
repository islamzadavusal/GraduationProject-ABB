package com.example.graduationproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentHomeBinding
import com.example.graduationproject.design.Adventure
import com.example.graduationproject.design.AdventureAdapter
import com.example.graduationproject.design.HomeAdapter
import com.example.graduationproject.design.HomeNext
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val adventureList = ArrayList<Adventure>()
        val a1 = Adventure(1,"image_11")
        val a2 = Adventure(2,"image_22")
        val a3 = Adventure(3,"image_33")
        val a4 = Adventure(4,"image_44")
        val a5 = Adventure(5,"image_55")
        val a6 = Adventure(6,"image_66")

        adventureList.add(a1)
        adventureList.add(a2)
        adventureList.add(a3)
        adventureList.add(a4)
        adventureList.add(a5)
        adventureList.add(a6)

        val adapter1 = AdventureAdapter(requireContext(),adventureList)

        binding.rv1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        binding.rv1.adapter = adapter1

//

        val homeList = ArrayList<HomeNext>()
        val h1 = HomeNext(1,"image_a1","Campaign")
        val h2 = HomeNext(2,"image_a2","Restaurant")
        val h3 = HomeNext(3,"image_a3","Quality")
        val h4 = HomeNext(4,"image_a4","Vacancy")
        val h5 = HomeNext(5,"image_a5","Contact Us")

        homeList.add(h1)
        homeList.add(h2)
        homeList.add(h3)
        homeList.add(h4)
        homeList.add(h5)

        val adapter2 = HomeAdapter(requireContext(),homeList)

        binding.rv2.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.rv2.adapter = adapter2

        return binding.root

    }
}