package fr.kodesparkle.motus.app

import android.app.Application
import android.content.pm.ApplicationInfo
import fr.kodesparkle.motus.di.appModules
import fr.kodesparkle.motus.utils.TimberConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MotusApp : Application(){

    override fun onCreate() {
        super.onCreate()
        setupKoin()
        setupTimber()
    }

    private fun setupKoin(){
        // Start Koin
        startKoin {
            // declare used Android context
            androidContext(this@MotusApp)
            // declare modules
            modules(appModules)
        }
    }

    private fun setupTimber(){
        val isDebuggable = (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
        TimberConfiguration.configure(isDebuggable)
    }
}