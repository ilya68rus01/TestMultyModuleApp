package ilya.khrushchev.thirdfeature

import com.example.moduleinjector.BaseFeatureDependencies
import ilya.khrushchev.core.providers.FirstFeatureDeps

interface ThirdFeatureDependencies : BaseFeatureDependencies {
    val contextProvider: FirstFeatureDeps
}