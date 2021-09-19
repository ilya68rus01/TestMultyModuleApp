package ilya.khrushchev.thirdfeature.di

import dagger.Component
import ilya.khrushchev.thirdfeature.ThirdFeatureApi
import ilya.khrushchev.thirdfeature.ThirdFeatureDependencies
import ilya.khrushchev.thirdfeature.ThirdFragment

@Component(
    modules = [
        ThirdFeatureModule::class
    ],
    dependencies = [
        ThirdFeatureDependencies::class
    ]
)
interface ThirdFeatureComponent : ThirdFeatureApi, ThirdFeatureDependencies {
    fun inject(fragment: ThirdFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: ThirdFeatureDependencies): ThirdFeatureComponent
    }
}