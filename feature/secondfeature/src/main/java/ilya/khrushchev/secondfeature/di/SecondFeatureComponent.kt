package ilya.khrushchev.secondfeature.di

import dagger.Component
import ilya.khrushchev.secondfeature.SecondFeatureApi
import ilya.khrushchev.secondfeature.SecondFeatureDependencies
import ilya.khrushchev.secondfeature.SecondFragment

@Component(
    modules = [
        SecondFeatureModule::class
    ],
    dependencies = [
        SecondFeatureDependencies::class
    ]
)
interface SecondFeatureComponent : SecondFeatureApi, SecondFeatureDependencies {

    fun inject(fragment: SecondFragment)

    @Component.Factory
    interface Factory {
        fun create(dependencies: SecondFeatureDependencies): SecondFeatureComponent
    }
}