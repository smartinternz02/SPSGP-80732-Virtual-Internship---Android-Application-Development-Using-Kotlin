package com.soumitra.grocery.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grocery_items")
data class GroceryItems(

    @ColumnInfo(name = "item_name")
    var itemName: String,

    @ColumnInfo(name = "item_quantity")
    var itemQuantity: Int,

    @ColumnInfo(name = "item_price")
    var itemPrice: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

