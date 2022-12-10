package com.example.graduationproject.design

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationproject.databinding.CardDesignAdventureBinding

class AdventureAdapter (var mContext: Context, var adventureList: List<Adventure>)
    : RecyclerView.Adapter<AdventureAdapter.CardDesignHolder>() {

    inner class CardDesignHolder (var binding: CardDesignAdventureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDesignAdventureBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val home = adventureList.get(position)
        val b = holder.binding

        b.imageViewAdventure.setImageResource(
            mContext.resources.getIdentifier(home.image,"drawable",mContext.packageName))

    }

    override fun getItemCount(): Int {
        return adventureList.size
    }
}