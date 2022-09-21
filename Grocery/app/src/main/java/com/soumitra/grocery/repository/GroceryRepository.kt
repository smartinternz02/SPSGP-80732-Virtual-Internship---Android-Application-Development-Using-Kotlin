package com.soumitra.grocery.repository

import com.soumitra.grocery.room.GroceryDatabase
import com.soumitra.grocery.room.GroceryItems

class GroceryRepository(private var db: GroceryDatabase) {

    suspend fun insert(items: GroceryItems) = db.getGroceryDao().insert(items)
    suspend fun delete(items: GroceryItems) = db.getGroceryDao().delete(items)

    fun getAllItems() = db.getGroceryDao().getAllGroceryItems()
}