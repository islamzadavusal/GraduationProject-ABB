package com.example.graduationproject.data.datasource


import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsCart
import com.example.graduationproject.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDatasource(var api:FoodsDao) {
//
    suspend fun insert(name: String, image: String, price: Int, category: String, orderAmount: Int, userName: String) = api.insert(name, image, price, category, orderAmount, userName)
//
    suspend fun delete(cartId: Int, userName: String) = api.delete(cartId, userName)
//
    suspend fun loadFoodsCart(): List<FoodsCart> =
        withContext(Dispatchers.IO) {
            api.loadFoodsCart("Vusal").foods_cart
        }
//
    suspend fun loadFoods(): List<Foods> =
        withContext(Dispatchers.IO) {
            api.loadFoods().foods
        }
//
    suspend fun search(searchText: String): List<Foods> =
        withContext(Dispatchers.IO) {
            api.search(searchText).foods
        }
}


