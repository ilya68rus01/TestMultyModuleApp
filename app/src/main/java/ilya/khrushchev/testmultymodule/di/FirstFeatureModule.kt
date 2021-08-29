package ilya.khrushchev.testmultymodule.di

import dagger.Module
import ilya.khrushchev.testmultymodule.navigation.FirstFeatureNavigationModule

@Module(includes = arrayOf(
    FirstFeatureNavigationModule::class)
)
interface FirstFeatureModule