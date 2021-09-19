package ilya.khrushchev.thirdfeature

import androidx.fragment.app.Fragment
import com.example.moduleinjector.BaseFeatureApi
import com.example.moduleinjector.ComponentHolder
import com.example.moduleinjector.ComponentHolderDelegate
import ilya.khrushchev.thirdfeature.di.DaggerThirdFeatureComponent
import ilya.khrushchev.thirdfeature.di.ThirdFeatureComponent


interface ThirdFeatureApi : BaseFeatureApi {
    val screenFactory: () -> Fragment
}

object ThirdFeatureComponentHolder : ComponentHolder<ThirdFeatureApi, ThirdFeatureDependencies> {

    private val componentHolderDelegate =
        ComponentHolderDelegate<ThirdFeatureApi, ThirdFeatureDependencies, ThirdFeatureComponent> { dependencyProvider ->
            DaggerThirdFeatureComponent
                .factory()
                .create(dependencyProvider)
        }

    override var dependencyProvider by componentHolderDelegate::dependencyProvider

    override fun get(): ThirdFeatureApi =
        componentHolderDelegate.get()

    internal fun getComponent(): ThirdFeatureComponent =
        componentHolderDelegate.getComponentImpl()

}
