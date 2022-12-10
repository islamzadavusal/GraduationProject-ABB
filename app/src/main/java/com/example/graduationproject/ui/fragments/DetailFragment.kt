package com.example.graduationproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.FoodsCart
import com.example.graduationproject.databinding.FragmentDetailBinding
import com.example.graduationproject.ui.viewmodel.DetailViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.detailFragment = this
        //
        val bundle: DetailFragmentArgs by navArgs()
        val resultFoods = bundle.foodsindetail

        binding.imageViewtoMenu.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toMenu)
        }

        binding.AddToCart.setOnClickListener {
            Snackbar.make(it, "Food has been added to your Cart", Snackbar.LENGTH_SHORT).show()




            val foodsCart = FoodsCart(
                cartId = 0,
                name = resultFoods.name,
                image = resultFoods.image,
                price = binding.textViewOrderDetail.text.toString().toInt() * resultFoods.price,
                category = resultFoods.category,
                orderAmount = binding.textViewOrderDetail.text.toString().toInt(),
                userName = "Vusal"
            )
            viewModel.insert(
                foodsCart.name,
                foodsCart.image,
                foodsCart.price,
                foodsCart.category,
                foodsCart.orderAmount,
                foodsCart.userName
            )
        }

        //

        binding.food = resultFoods

        binding.imageViewtoCart.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.DetailtoCart)
        }
        Glide.with(requireContext())
            .load("http://kasimadalan.pe.hu/foods/images/${resultFoods.image}")
            .into(binding.imageViewDetail)

        binding.textViewNameDetail.setText(resultFoods.name)
        binding.textViewCategoryDetail.setText(resultFoods.category)
        binding.textViewPriceDetail.setText("${resultFoods.price}  ₼")
//
        var num = 1
        binding.btnplus.setOnClickListener {
            num++
            binding.textViewOrderDetail.text = num.toString()
        }
//
        binding.btnminus.setOnClickListener {
            num--
            binding.textViewOrderDetail.text = num.toString()
        }

        return binding.root
    }

    private fun increaseAmount(foodsCart: FoodsCart) {
        val count = binding.textViewPriceDetail.text.toString().toInt()
        binding.textViewOrderDetail.text = "${count + 1}"
        binding.textViewPriceDetail.text =
            "Total price: ${binding.textViewOrderDetail.text.toString().toInt() * foodsCart.price} ₼"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }
    }


