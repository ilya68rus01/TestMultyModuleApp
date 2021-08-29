package ilya.khrushchev.testmultymodule.navigation

import dagger.Binds
import dagger.Module
import ilya.khrushchev.firstfeature.navigation.FirstFeatureNavCommandProvider

@Module
interface FirstFeatureNavigationModule {

    @Binds
    fun bindFirstFeature(impl: FirstFeatureNavCommandProviderImpl): FirstFeatureNavCommandProvider
}