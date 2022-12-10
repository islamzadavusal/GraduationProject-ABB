package com.example.graduationproject.design

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentConfirmCartBinding

class ConfirmCartFragment : Fragment() {
    private lateinit var binding: FragmentConfirmCartBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConfirmCartBinding.inflate(inflater, container, false)

        return binding.root
    }

}