package ilya.khrushchev.firstfeature

import androidx.fragment.app.Fragment
import com.example.moduleinjector.BaseFeatureApi
import com.example.moduleinjector.ComponentHolder
import com.example.moduleinjector.ComponentHolderDelegate
import ilya.khrushchev.firstfeature.di.DaggerFirstFeatureComponent
import ilya.khrushchev.firstfeature.di.FirstFeatureComponent


interface FirstFeatureApi : BaseFeatureApi {
    val screenFactory: () -> Fragment
}

object FirstFeatureComponentHolder : ComponentHolder<FirstFeatureApi, FirstFeatureDependencies> {

    private val componentHolderDelegate =
        ComponentHolderDelegate<FirstFeatureApi, FirstFeatureDependencies, FirstFeatureComponent> { dependencies ->
            DaggerFirstFeatureComponent
                .factory()
                .create(dependencies)
        }

    override var dependencyProvider by componentHolderDelegate::dependencyProvider

    override fun get(): FirstFeatureApi =
        componentHolderDelegate.get()

    internal fun getComponent(): FirstFeatureComponent =
        componentHolderDelegate.getComponentImpl()
}
