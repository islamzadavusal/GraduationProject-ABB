package com.example.graduationproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor (var crepo: FoodRepository) : ViewModel() {
//
fun insert(name: String, image: String, price: Int, category:String, orderAmount: Int, userName: String){
    CoroutineScope(Dispatchers.Main).launch {
        crepo.insert(name,image, price, category, orderAmount, userName)

    }
}
}

