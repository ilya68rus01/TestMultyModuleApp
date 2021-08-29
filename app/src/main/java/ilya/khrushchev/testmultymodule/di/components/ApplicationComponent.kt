package ilya.khrushchev.testmultymodule.di.components

import dagger.Component
import ilya.khrushchev.core.*
import ilya.khrushchev.firstfeature.FirstFeatureExportComponent
import ilya.khrushchev.secondfeature.SecondFeatureExportComponent
import ilya.khrushchev.testmultymodule.Application
import ilya.khrushchev.testmultymodule.di.ApplicationScope
import ilya.khrushchev.thirdfeature.ThirdFeatureExportComponent

@ApplicationScope
@Component(
    dependencies = [
        MainToolsProvider::class,
        FirstFeatureProvider::class,
        SecondFeatureProvider::class,
        ThirdFeatureProvider::class
    ]
)
interface ApplicationComponent : ApplicationProvider {
    fun inject(app: Application)

    class Initializer private constructor() {
        companion object {
            fun init(app: Application): ApplicationComponent {
                val mainToolsProvider = DaggerMainToolsComponent.factory().create(app)
                val firstFeatureProvider = FirstFeatureExportComponent.Initializer.init(mainToolsProvider)
                val secondFeatureProvider = SecondFeatureExportComponent.Initializer.init(mainToolsProvider)
                val thirdFeatureProvider = ThirdFeatureExportComponent.Initializer.init(mainToolsProvider)
                return DaggerApplicationComponent.builder()
                    .mainToolsProvider(mainToolsProvider)
                    .firstFeatureProvider(firstFeatureProvider)
                    .secondFeatureProvider(secondFeatureProvider)
                    .thirdFeatureProvider(thirdFeatureProvider)
                    .build()
            }
        }
    }
}