package ilya.khrushchev.core

interface ApplicationProvider :
    MainToolsProvider,
    FirstFeatureProvider,
    SecondFeatureProvider,
    ThirdFeatureProvider

interface MainToolsProvider {
    fun provideContext(): App
}

interface FirstFeatureProvider{}

interface SecondFeatureProvider{}

interface ThirdFeatureProvider{}
