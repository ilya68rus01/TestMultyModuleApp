package ilya.khrushchev.testmultymodule

import android.app.Application
import com.example.moduleinjector.*
import ilya.khrushchev.core.providers.ContextProvider
import ilya.khrushchev.core.providers.FirstFeatureDeps
import ilya.khrushchev.firstfeature.FirstFeatureApi
import ilya.khrushchev.firstfeature.FirstFeatureComponentHolder
import ilya.khrushchev.firstfeature.FirstFeatureDependencies
import ilya.khrushchev.secondfeature.SecondFeatureComponentHolder
import ilya.khrushchev.secondfeature.SecondFeatureDependencies
import ilya.khrushchev.testmultymodule.di.components.ApplicationComponent
import ilya.khrushchev.testmultymodule.di.components.ApplicationComponent.Builder.Companion.build

class ExampleApp: Application() {

    companion object {
        lateinit var instance: ExampleApp
            private set

        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        instance = this

        appComponent = build(this).apply {
            inject(this@ExampleApp)
        }

        super.onCreate()

        connectModules()

    }

    private fun connectModules() {
        FirstFeatureComponentHolder.dependencyProvider = {
            DependencyHolder1<ApplicationComponent, FirstFeatureDependencies>(
                api1 = appComponent
            ) { holder, appComponent ->
                object : FirstFeatureDependencies {
                    override val contextProvider: FirstFeatureDeps = appComponent
                    override val dependencyHolder = holder
                }
            }.dependencies
        }

        SecondFeatureComponentHolder.dependencyProvider = {
            DependencyHolder1<ApplicationComponent, SecondFeatureDependencies>(
                api1 = appComponent
            ) { holder, appComponent ->
                object : SecondFeatureDependencies {
                    override val contextProvider: FirstFeatureDeps = appComponent
                    override val dependencyHolder = holder
                }
            }.dependencies
        }
    }

}
