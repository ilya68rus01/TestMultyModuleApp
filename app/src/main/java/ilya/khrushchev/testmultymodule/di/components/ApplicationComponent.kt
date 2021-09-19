package ilya.khrushchev.testmultymodule.di.components

import com.example.moduleinjector.BaseFeatureApi
import dagger.Component
import ilya.khrushchev.core.providers.ContextProvider
import ilya.khrushchev.core.providers.DaggerContextComponent
import ilya.khrushchev.core.providers.FirstFeatureDeps
import ilya.khrushchev.testmultymodule.ExampleApp
import ilya.khrushchev.testmultymodule.di.ApplicationScope

@ApplicationScope
@Component(
    dependencies = [
        ContextProvider::class
    ]
)
interface ApplicationComponent : BaseFeatureApi, FirstFeatureDeps  {

    fun inject(app: ExampleApp)

    class Builder {
        companion object {
            fun build(app: ExampleApp): ApplicationComponent {
                val contextProvider = DaggerContextComponent.factory().create(app)
                return DaggerApplicationComponent.builder()
                    .contextProvider(contextProvider)
                    .build()
            }
        }
    }
}
