package ilya.khrushchev.secondfeature

import dagger.Component
import ilya.khrushchev.core.ApplicationProvider

@Component(
    dependencies = [
        ApplicationProvider::class
    ]
)
interface SecondFeatureComponent {
    fun inject(fragment: SecondFragment)

    class Initializer private constructor() {
        companion object {
            fun init(applicationProvider: ApplicationProvider): SecondFeatureComponent {
                return DaggerSecondFeatureComponent.builder()
                    .applicationProvider(applicationProvider)
                    .build()
            }
        }
    }
}