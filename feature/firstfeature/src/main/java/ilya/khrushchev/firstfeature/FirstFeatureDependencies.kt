package ilya.khrushchev.firstfeature

import com.example.moduleinjector.BaseFeatureDependencies
import ilya.khrushchev.core.providers.FirstFeatureDeps

interface FirstFeatureDependencies : BaseFeatureDependencies {
    val contextProvider: FirstFeatureDeps
}
