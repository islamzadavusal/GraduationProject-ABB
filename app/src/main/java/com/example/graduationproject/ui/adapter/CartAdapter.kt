package com.example.graduationproject.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.FoodsCart
import com.example.graduationproject.databinding.CardDesignCartBinding
import com.example.graduationproject.ui.viewmodel.MyCartViewModel
import com.google.android.material.snackbar.Snackbar

class CartAdapter (var mContext: Context, var cartList:List<FoodsCart>, var viewModel: MyCartViewModel)
    : RecyclerView.Adapter<CartAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(var binding: CardDesignCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignCartBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(binding)

    }

    override fun onBindViewHolder(holder: CartAdapter.CardDesignHolder, position: Int) {
        val foodcart = cartList.get(position)
        val b = holder.binding

        val url = "http://kasimadalan.pe.hu/foods/images/${foodcart.image}"
        Glide.with(mContext).load(url).into(b.imageViewCart)

        b.textViewFoodNameCart.text = "${foodcart.name}"
        b.textViewPriceCart.text = "${foodcart.price} ₼"
        b.textViewUsername.text = "Username:  ${foodcart.userName}"
        b.textViewCategoryinCart.text = "Category:  ${foodcart.category}"
        b.textVieworderAmountCart.text = "Order:  ${foodcart.orderAmount}"

        b.imageViewDelete.setOnClickListener{
            Snackbar.make(it,"Do you want to delete ${foodcart.name}?",Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    viewModel.delete(foodcart.cartId, foodcart.userName)
                }.show()
                }
        }

    override fun getItemCount(): Int {
        return cartList.size

    }
}

