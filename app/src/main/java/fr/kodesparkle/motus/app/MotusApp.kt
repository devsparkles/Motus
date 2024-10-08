package fr.kodesparkle.motus.app

import android.app.Application
import android.content.pm.ApplicationInfo
import dagger.hilt.android.HiltAndroidApp
import fr.kodesparkle.motus.utils.TimberConfiguration

@HiltAndroidApp
class MotusApp : Application(){

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber(){
        val isDebuggable = (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
        TimberConfiguration.configure(isDebuggable)
    }
}