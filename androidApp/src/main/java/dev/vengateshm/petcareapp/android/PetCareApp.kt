package dev.vengateshm.petcareapp.android

import android.app.Application
import dev.vengateshm.petcareapp.android.di.apiClientModule
import dev.vengateshm.petcareapp.android.di.dataSourceModule
import dev.vengateshm.petcareapp.android.di.platformModule
import dev.vengateshm.petcareapp.android.di.repositoryModule
import dev.vengateshm.petcareapp.android.di.useCaseModule
import dev.vengateshm.petcareapp.android.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PetCareApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@PetCareApp)
            modules(
                listOf(
                    viewModelModule,
                    useCaseModule,
                    repositoryModule,
                    dataSourceModule,
                    platformModule,
                    apiClientModule
                )
            )
        }
    }
}