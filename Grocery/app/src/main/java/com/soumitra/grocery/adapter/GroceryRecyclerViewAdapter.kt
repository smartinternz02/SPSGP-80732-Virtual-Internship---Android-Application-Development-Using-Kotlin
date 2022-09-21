package com.soumitra.grocery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soumitra.grocery.databinding.GroceryRecyclerviewItemsBinding
import com.soumitra.grocery.room.GroceryItems

class GroceryRecyclerViewAdapter(var list: List<GroceryItems>, var click: GroceryItemClick) :
    RecyclerView.Adapter<GroceryRecyclerViewAdapter.groceryViewHolder>() {

    interface GroceryItemClick {
        fun onItemClick(items: GroceryItems, position: Int)
    }

    inner class groceryViewHolder(var binding: GroceryRecyclerviewItemsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items: GroceryItems, position: Int) {
            binding.itemName.text = items.itemName
            binding.itemQuantity.text ="Quantity: " + items.itemQuantity.toString()
            binding.itemRate.text = "₹ " + items.itemPrice.toString()
            binding.totalAmount.text ="₹ " + (items.itemPrice * items.itemQuantity).toString()

            binding.itemDelete.setOnClickListener {
                click.onItemClick(items, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): groceryViewHolder {
        return groceryViewHolder(GroceryRecyclerviewItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: groceryViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}