package ilya.khrushchev.secondfeature

import androidx.fragment.app.Fragment
import com.example.moduleinjector.BaseFeatureApi
import com.example.moduleinjector.ComponentHolder
import com.example.moduleinjector.ComponentHolderDelegate
import ilya.khrushchev.secondfeature.di.DaggerSecondFeatureComponent
import ilya.khrushchev.secondfeature.di.SecondFeatureComponent


interface SecondFeatureApi : BaseFeatureApi {
    val screenFactory: () -> Fragment
}

object SecondFeatureComponentHolder: ComponentHolder<SecondFeatureApi, SecondFeatureDependencies> {

    private val componentHolderDelegate =
        ComponentHolderDelegate<SecondFeatureApi,SecondFeatureDependencies, SecondFeatureComponent> {
            dependencyProvider ->
                DaggerSecondFeatureComponent
                    .factory()
                    .create(dependencyProvider)
        }

    override var dependencyProvider by componentHolderDelegate::dependencyProvider

    override fun get(): SecondFeatureApi =
        componentHolderDelegate.get()

    internal fun getComponent(): SecondFeatureComponent =
        componentHolderDelegate.getComponentImpl()

}