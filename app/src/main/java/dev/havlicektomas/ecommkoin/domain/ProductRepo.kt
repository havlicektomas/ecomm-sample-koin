package dev.havlicektomas.ecommkoin.domain

import kotlinx.coroutines.flow.Flow

interface ProductRepo {
    fun loadProducts(): Flow<List<Product>>
}