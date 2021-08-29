package ilya.khrushchev.core.providers

import android.app.Application
import android.content.Context

interface FirstFeatureDeps {
    fun provideContext(): Context
    fun provideApplication(): Application
}
