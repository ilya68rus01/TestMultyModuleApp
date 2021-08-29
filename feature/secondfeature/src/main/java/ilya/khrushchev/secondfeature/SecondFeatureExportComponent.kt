package ilya.khrushchev.secondfeature

import dagger.Component
import ilya.khrushchev.core.FirstFeatureProvider
import ilya.khrushchev.core.MainToolsProvider
import ilya.khrushchev.core.SecondFeatureProvider

@Component(
    dependencies = arrayOf(MainToolsProvider::class),
    modules = arrayOf(SecondFeatureModule::class)
)
interface SecondFeatureExportComponent : SecondFeatureProvider {
    class Initializer private constructor() {
        companion object{
            fun init(mainToolsProvider: MainToolsProvider): SecondFeatureProvider =
                DaggerSecondFeatureExportComponent.builder()
                    .mainToolsProvider(mainToolsProvider)
                    .build()
        }
    }
}