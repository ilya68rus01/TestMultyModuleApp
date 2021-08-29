package ilya.khrushchev.firstfeature

import com.example.moduleinjector.BaseDependencyHolder
import com.example.moduleinjector.BaseFeatureDependencies
import ilya.khrushchev.core.providers.ContextProvider
import ilya.khrushchev.core.providers.FirstFeatureDeps

interface FirstFeatureDependencies : BaseFeatureDependencies {
    val contextProvider: FirstFeatureDeps
}
