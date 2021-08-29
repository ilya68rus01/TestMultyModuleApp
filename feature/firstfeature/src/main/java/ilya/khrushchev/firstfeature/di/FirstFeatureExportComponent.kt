package ilya.khrushchev.firstfeature.di

import dagger.Component
import ilya.khrushchev.core.FirstFeatureProvider
import ilya.khrushchev.core.MainToolsProvider


@Component(
    dependencies = arrayOf(MainToolsProvider::class)
)
interface FirstFeatureExportComponent : FirstFeatureProvider {
//    class Initializer private constructor() {
//        companion object{
//            fun init(mainToolsProvider: MainToolsProvider): FirstFeatureProvider =
//                DaggerFirstFeatureExportComponent.builder()
//                    .mainToolsProvider(mainToolsProvider)
//                    .build()
//        }
//    }
}
