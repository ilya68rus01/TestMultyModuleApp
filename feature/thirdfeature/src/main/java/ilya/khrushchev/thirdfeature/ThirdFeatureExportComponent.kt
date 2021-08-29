package ilya.khrushchev.thirdfeature

import dagger.Component
import ilya.khrushchev.core.FirstFeatureProvider
import ilya.khrushchev.core.MainToolsProvider
import ilya.khrushchev.core.SecondFeatureProvider
import ilya.khrushchev.core.ThirdFeatureProvider

@Component(
    dependencies = arrayOf(MainToolsProvider::class),
    modules = arrayOf(ThirdFeatureModule::class)
)
interface ThirdFeatureExportComponent : ThirdFeatureProvider {
    class Initializer private constructor() {
        companion object{
            fun init(mainToolsProvider: MainToolsProvider): ThirdFeatureProvider =
                DaggerThirdFeatureExportComponent.builder()
                    .mainToolsProvider(mainToolsProvider)
                    .build()
        }
    }
}