package ilya.khrushchev.testmultymodule

import android.app.Application
import com.example.moduleinjector.*
import com.example.navigation.NavigationComponent
import com.example.navigation.NavigationComponentHolder
import com.example.navigation.NavigationDependencies
import com.example.navigation.NavigationProvider
import ilya.khrushchev.core.providers.ContextProvider
import ilya.khrushchev.core.providers.FirstFeatureDeps
import ilya.khrushchev.core.providers.NavigationCommand
import ilya.khrushchev.firstfeature.FirstFeatureApi
import ilya.khrushchev.firstfeature.FirstFeatureComponentHolder
import ilya.khrushchev.firstfeature.FirstFeatureDependencies
import ilya.khrushchev.secondfeature.SecondFeatureComponentHolder
import ilya.khrushchev.secondfeature.SecondFeatureDependencies
import ilya.khrushchev.testmultymodule.di.components.ApplicationComponent
import ilya.khrushchev.testmultymodule.di.components.ApplicationComponent.Builder.Companion.build
import ilya.khrushchev.thirdfeature.ThirdFeatureComponentHolder
import ilya.khrushchev.thirdfeature.ThirdFeatureDependencies

class ExampleApp: Application() {

    companion object {
        lateinit var instance: ExampleApp
            private set

        lateinit var appComponent: ApplicationComponent
        lateinit var navigationComponent: NavigationComponent
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
                api1 = appComponent,
            ) { holder, appComponent ->
                object : FirstFeatureDependencies {
                    override val contextProvider: FirstFeatureDeps = appComponent
                    override val navigationCommand: NavigationCommand = NavigationProvider()
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

        ThirdFeatureComponentHolder.dependencyProvider = {
            DependencyHolder1<ApplicationComponent, ThirdFeatureDependencies>(
                api1 = appComponent
            ) { holder, appComponent ->
                object : ThirdFeatureDependencies {
                    override val contextProvider: FirstFeatureDeps = appComponent
                    override val dependencyHolder = holder
                }
            }.dependencies
        }

        NavigationComponentHolder.dependencyProvider = {
            DependencyHolder0<NavigationDependencies>{
                baseDependencyHolder ->
                object : NavigationDependencies {
                    override val navigation = NavigationProvider()
                    override val dependencyHolder = baseDependencyHolder
                }
            }.dependencies
        }
    }

}
