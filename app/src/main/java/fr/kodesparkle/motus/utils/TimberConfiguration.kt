package fr.kodesparkle.motus.utils

import android.util.Log

import org.jetbrains.annotations.NotNull
import timber.log.Timber


object TimberConfiguration {


    fun configure(isDebuggable: Boolean) {
        if (isDebuggable) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return String.format(
                        "Class:%s: Line: %s, Method: %s",
                        super.createStackElementTag(element),
                        element.lineNumber,
                        element.methodName
                    )
                }
            })
        } else {
            Timber.plant(ReleaseTree())
        }
    }


    class ReleaseTree : @NotNull Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.ERROR || priority == Log.WARN) {
                //SEND ERROR REPORTS TO YOUR Crashlytics for example
            }
        }
    }


}