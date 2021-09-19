package ilya.khrushchev.secondfeature

import com.example.moduleinjector.BaseFeatureDependencies
import ilya.khrushchev.core.providers.FirstFeatureDeps

interface SecondFeatureDependencies : BaseFeatureDependencies {
    val contextProvider: FirstFeatureDeps
}