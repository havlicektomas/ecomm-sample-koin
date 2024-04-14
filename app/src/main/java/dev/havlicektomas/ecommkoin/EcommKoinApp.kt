package dev.havlicektomas.ecommkoin

import android.app.Application
import dev.havlicektomas.ecommkoin.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EcommKoinApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EcommKoinApp)
            modules(appModule)
        }
    }
}