package ru.izhxx.ecommerceconcept

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.izhxx.ecommerceconcept.di.dataModule
import ru.izhxx.ecommerceconcept.di.networkModule
import ru.izhxx.ecommerceconcept.di.useCasesModule
import ru.izhxx.ecommerceconcept.di.viewModelsModule

class EcommerceConceptApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            modules(networkModule, dataModule, useCasesModule, viewModelsModule)
        }
    }
}