package com.example.graduationproject.data.repo

import com.example.graduationproject.data.datasource.FoodDatasource
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsCart

class FoodRepository(var fds: FoodDatasource) {

    suspend fun loadFoods() : List<Foods> = fds.loadFoods()

    suspend fun search(searchText:String) : List<Foods> = fds.search(searchText)

    suspend fun insert(name: String, image: String, price: Int, category:String, orderAmount: Int, userName: String) = fds.insert(name,image,price,category,orderAmount,userName)

    suspend fun delete(cartId:Int, userName: String) = fds.delete(cartId, userName)

    suspend fun loadFoodsCart() : List<FoodsCart> = fds.loadFoodsCart()




}