package com.soumitra.grocery.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soumitra.grocery.repository.GroceryRepository
import com.soumitra.grocery.viewmodel.GroceryViewModel

class GroceryViewModelFactory(private var repository: GroceryRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GroceryViewModel(repository) as T
    }
}