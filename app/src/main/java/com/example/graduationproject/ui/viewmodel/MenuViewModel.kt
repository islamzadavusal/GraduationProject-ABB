package com.example.graduationproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.repo.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor (var frepo: FoodRepository) : ViewModel() {
    var foodList = MutableLiveData<List<Foods>>()

    init {
        loadFoods()

    }
//
    fun loadFoods() {
        CoroutineScope(Dispatchers.Main).launch {
            foodList.value = frepo.loadFoods()
        }
    }
//
    fun search(searchText: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                foodList.value = frepo.search(searchText)
            } catch (e: Exception) {
            }

        }
    }
}

