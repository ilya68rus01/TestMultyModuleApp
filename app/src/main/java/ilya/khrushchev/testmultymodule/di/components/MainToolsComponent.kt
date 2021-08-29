package ilya.khrushchev.testmultymodule.di.components

import dagger.BindsInstance
import dagger.Component
import ilya.khrushchev.core.App
import ilya.khrushchev.core.MainToolsProvider

@Component
interface MainToolsComponent: MainToolsProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): MainToolsProvider
    }
}