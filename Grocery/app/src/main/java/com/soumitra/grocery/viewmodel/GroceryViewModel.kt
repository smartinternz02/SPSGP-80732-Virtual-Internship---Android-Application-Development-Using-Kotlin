package com.soumitra.grocery.viewmodel

import androidx.lifecycle.ViewModel
import com.soumitra.grocery.repository.GroceryRepository
import com.soumitra.grocery.room.GroceryItems
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@DelicateCoroutinesApi
class GroceryViewModel(private var repository: GroceryRepository) : ViewModel() {

    fun insert(items: GroceryItems) = GlobalScope.launch {
        repository.insert(items)
    }

    fun delete(items: GroceryItems) = GlobalScope.launch {
        repository.delete(items)
    }

    fun getAllGroceryItems() = repository.getAllItems()
}