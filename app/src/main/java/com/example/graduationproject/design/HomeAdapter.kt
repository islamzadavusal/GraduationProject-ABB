package com.example.graduationproject.design

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationproject.databinding.CardDesignHomeBinding

class HomeAdapter (var mContext: Context, var homeList: List<HomeNext>)
    : RecyclerView.Adapter<HomeAdapter.CardDesignHolder>() {

    inner class CardDesignHolder (var binding: CardDesignHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignHomeBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val home = homeList.get(position)
        val b = holder.binding

        b.imageViewImage.setImageResource(
            mContext.resources.getIdentifier(home.image,"drawable",mContext.packageName))

        b.textViewName.text = "${home.name}"
    }

    override fun getItemCount(): Int {
       return homeList.size
    }
}