package ilya.khrushchev.thirdfeature

import dagger.Component
import ilya.khrushchev.core.ApplicationProvider

@Component(
    dependencies = [
        ApplicationProvider::class
    ]
)
interface ThirdFeatureComponent {
    fun inject(fragment: ThirdFragment)

    class Initializer private constructor() {
        companion object {
            fun init(applicationProvider: ApplicationProvider): ThirdFeatureComponent {
                return DaggerThirdFeatureComponent.builder()
                    .applicationProvider(applicationProvider)
                    .build()
            }
        }
    }
}