package ilya.khrushchev.firstfeature

import dagger.Component
import ilya.khrushchev.core.ApplicationProvider

@Component(
    dependencies = [
        ApplicationProvider::class
    ]
)
interface FirstFeatureComponent {
    fun inject(fragment: FirstFragment)

    class Initializer private constructor() {
        companion object {
            fun init(applicationProvider: ApplicationProvider): FirstFeatureComponent {
                return DaggerFirstFeatureComponent.builder()
                    .applicationProvider(applicationProvider)
                    .build()
            }
        }
    }
}