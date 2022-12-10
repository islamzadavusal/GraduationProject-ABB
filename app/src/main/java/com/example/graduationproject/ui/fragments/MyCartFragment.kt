package com.example.graduationproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentMyCartBinding
import com.example.graduationproject.ui.adapter.CartAdapter
import com.example.graduationproject.ui.viewmodel.DetailViewModel
import com.example.graduationproject.ui.viewmodel.MyCartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyCartFragment : Fragment() {
    private lateinit var binding: FragmentMyCartBinding
    private lateinit var viewModel: MyCartViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_cart, container, false)
        binding.mycartFragment = this

        binding.btnConfirmCart.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toConfirm)
        }

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MyCartViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cartList.observe(viewLifecycleOwner){
            val adapter = CartAdapter(requireContext(),it,viewModel)
            binding.adapter = adapter
        }
        viewModel.loadFoodsCart("Vusal")

        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())

    }
        override fun onResume() {
            super.onResume()
            viewModel.loadFoodsCart("Vusal")

    }
}