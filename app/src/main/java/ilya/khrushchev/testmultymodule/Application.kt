package ilya.khrushchev.testmultymodule

import android.app.Application
import ilya.khrushchev.core.App
import ilya.khrushchev.core.ApplicationProvider
import ilya.khrushchev.testmultymodule.di.components.ApplicationComponent

class Application: Application(), App {

    val applicationComponent: ApplicationComponent by lazy {
        ApplicationComponent.Initializer.init(this@Application)
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun getAppComponent(): ApplicationProvider = applicationComponent
}