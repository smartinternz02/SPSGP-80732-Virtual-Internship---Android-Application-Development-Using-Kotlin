package com.soumitra.grocery

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.soumitra.grocery.adapter.GroceryRecyclerViewAdapter
import com.soumitra.grocery.databinding.ActivityMainBinding
import com.soumitra.grocery.databinding.GroceryAddDialogBinding
import com.soumitra.grocery.repository.GroceryRepository
import com.soumitra.grocery.room.GroceryDatabase
import com.soumitra.grocery.room.GroceryItems
import com.soumitra.grocery.viewmodel.GroceryViewModel
import com.soumitra.grocery.viewmodelfactory.GroceryViewModelFactory
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlin.OptIn as OptIn1

class MainActivity : AppCompatActivity(), GroceryRecyclerViewAdapter.GroceryItemClick {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<GroceryItems>
    private lateinit var groceryRvAdapter: GroceryRecyclerViewAdapter
    @DelicateCoroutinesApi
    private lateinit var groceryViewModel: GroceryViewModel

    @OptIn1(DelicateCoroutinesApi::class)
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        groceryRvAdapter = GroceryRecyclerViewAdapter(list, this)
        binding.rvItems.adapter = groceryRvAdapter

        val groceryRepository = GroceryRepository(GroceryDatabase(this))
        val factory = GroceryViewModelFactory(groceryRepository)

        groceryViewModel = ViewModelProvider(this, factory)[GroceryViewModel::class.java]
        groceryViewModel.getAllGroceryItems().observe(this) {
            groceryRvAdapter.list = it
            groceryRvAdapter.notifyDataSetChanged()
        }

        binding.fabAdd.setOnClickListener {
            openDialog()
        }
    }

    @OptIn1(DelicateCoroutinesApi::class)
    @SuppressLint("NotifyDataSetChanged")
    private fun openDialog() {
        val dialog =  Dialog(this)
        val bind = GroceryAddDialogBinding.inflate(layoutInflater)

        dialog.setContentView(bind.root)

        bind.cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        bind.addButton.setOnClickListener {
            if (bind.enterItemName.text?.isNotEmpty() == true && bind.enterItemQuantity.text?.isNotEmpty() == true && bind.enterItemPrice.text?.isNotEmpty() == true) {

                val items = GroceryItems(bind.enterItemName.text?.toString().toString(),
                    bind.enterItemQuantity.text?.toString()?.toInt()!!,
                    bind.enterItemPrice.text?.toString()?.toInt()!!
                )
                groceryViewModel.insert(items)
                Toast.makeText(applicationContext, "Item Inserted...", Toast.LENGTH_SHORT).show()
                groceryRvAdapter.notifyDataSetChanged()

                dialog.dismiss()
            }
            else {
                Toast.makeText(applicationContext, "Please enter all the data...", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()
    }

    @OptIn1(DelicateCoroutinesApi::class)
    override fun onItemClick(items: GroceryItems, position: Int) {
        groceryViewModel.delete(items)
        groceryRvAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext, "Item Deleted...", Toast.LENGTH_SHORT).show()
    }
}