package com.example.graduationproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.databinding.CardDesignMenuBinding
import com.example.graduationproject.ui.fragments.MenuFragmentDirections
import com.example.graduationproject.ui.viewmodel.MenuViewModel
import com.example.graduationproject.util.go

class FoodsAdapter(var mContext: Context, var foodsList:List<Foods>, var viewModel: MenuViewModel)
    : RecyclerView.Adapter<FoodsAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(var binding: CardDesignMenuBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignMenuBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)
    }
//
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food = foodsList.get(position)
        val b = holder.binding
//
        val url = "http://kasimadalan.pe.hu/foods/images/${food.image}"
        Glide.with(mContext).load(url).override(500,500).into(b.imageViewMenu)
//
        b.cardViewFoodMenu.setOnClickListener{
            val transition = MenuFragmentDirections.toDetail(foodsindetail = food)
            Navigation.go(it,transition) }
//
        b.textViewFoodNameMenu.text = "${food.name}"
        b.textViewPriceMenu.text = "${food.price} ₼"
        b.textViewCategoryinMenu.text = "${food.category}"

    }

    override fun getItemCount(): Int {
        return foodsList.size
    }

}