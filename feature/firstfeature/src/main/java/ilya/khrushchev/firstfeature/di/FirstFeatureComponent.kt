package ilya.khrushchev.firstfeature.di

import dagger.Component
import ilya.khrushchev.core.ApplicationProvider
import ilya.khrushchev.firstfeature.FirstFeatureApi
import ilya.khrushchev.firstfeature.FirstFeatureDependencies
import ilya.khrushchev.firstfeature.FirstFragment

@Component(
    modules = [
        FirstFeatureModule::class
    ],
    dependencies = [
        FirstFeatureDependencies::class
    ]
)
interface FirstFeatureComponent : FirstFeatureApi, FirstFeatureDependencies {

    fun inject(fragment: FirstFragment)

    @Component.Factory
    interface Factory {
        fun create(deps: FirstFeatureDependencies): FirstFeatureComponent
    }

}
