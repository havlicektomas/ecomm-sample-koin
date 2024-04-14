package dev.havlicektomas.ecommkoin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.havlicektomas.ecommkoin.domain.Product
import dev.havlicektomas.ecommkoin.domain.ProductRepo
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class ProductListViewModel(
    private val productRepo: ProductRepo
): ViewModel() {

    val state: StateFlow<List<Product>> = productRepo
        .loadProducts()
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            emptyList()
        )
}