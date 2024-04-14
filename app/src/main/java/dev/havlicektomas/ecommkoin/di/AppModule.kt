package dev.havlicektomas.ecommkoin.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.havlicektomas.ecommkoin.data.DefaultProductRepo
import dev.havlicektomas.ecommkoin.data.ProductApi
import dev.havlicektomas.ecommkoin.domain.ProductRepo
import dev.havlicektomas.ecommkoin.presentation.ProductListViewModel
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    single {
        val okHttpClient = OkHttpClient.Builder()
            .build()
        val networkJson = Json { ignoreUnknownKeys = true }

        Retrofit.Builder()
            .baseUrl(ProductApi.BASE_URL)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()
            .create(ProductApi::class.java)
    }

    single<ProductRepo> {
        DefaultProductRepo(get())
    }

    viewModel {
        ProductListViewModel(get())
    }
}