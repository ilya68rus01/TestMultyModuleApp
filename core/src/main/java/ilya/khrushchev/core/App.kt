package ilya.khrushchev.core

import android.content.Context

interface App {
    fun getApplicationContext(): Context
    fun getAppComponent(): ApplicationProvider
}