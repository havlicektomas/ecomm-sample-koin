package dev.havlicektomas.ecommkoin.data

import android.util.Log
import dev.havlicektomas.ecommkoin.domain.Product
import dev.havlicektomas.ecommkoin.domain.ProductRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DefaultProductRepo(
    private val productApi: ProductApi
): ProductRepo {
    override fun loadProducts(): Flow<List<Product>> {
        return flow {
            val response = productApi.getProducts(20)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(it)
                }
            } else {
                Log.d("DefaultProductRepo", "loadProducts failed")
            }
        }
    }
}