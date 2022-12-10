package com.example.graduationproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.entity.FoodsCart
import com.example.graduationproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyCartViewModel @Inject constructor (var crepo: FoodRepository) :ViewModel() {
    var cartList = MutableLiveData<List<FoodsCart>>()

    init {
        loadFoodsCart("Vusal")
    }
//
    fun loadFoodsCart(userName: String) {
    CoroutineScope(Dispatchers.Main).launch {
        try{
        cartList.value = crepo.loadFoodsCart()

    } catch (e:Exception){
        cartList.value = mutableListOf()
    }
  }
}
//
    fun delete(CartId:Int, userName:String){
        CoroutineScope(Dispatchers.Main).launch {
            crepo.delete(CartId, userName)
            loadFoodsCart("Vusal")

    }
  }
}

