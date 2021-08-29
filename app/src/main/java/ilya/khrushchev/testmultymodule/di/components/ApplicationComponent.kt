package ilya.khrushchev.testmultymodule.di.components

import android.app.Application
import android.content.Context
import com.example.moduleinjector.BaseFeatureApi
import dagger.Component
import ilya.khrushchev.core.providers.ContextProvider
import ilya.khrushchev.core.providers.DaggerContextComponent
import ilya.khrushchev.core.providers.FirstFeatureDeps
import ilya.khrushchev.testmultymodule.ExampleApp
import ilya.khrushchev.testmultymodule.di.ApplicationScope

interface ApplicationProvider {

}

@ApplicationScope
@Component(
    dependencies = [
        ContextProvider::class
//        ThirdFeatureProvider::class,
//        FirstFeatureModule::class,
//        FirstFeatureNavigationModule::class
    ]
)
interface ApplicationComponent : BaseFeatureApi, FirstFeatureDeps  {

    fun inject(app: ExampleApp)

    class Builder {
        companion object {
            fun build(app: ExampleApp): ApplicationComponent {
                val contextProvider = DaggerContextComponent.factory().create(app)
//                val mainToolsProvider = DaggerMainToolsComponent.factory().create(app)
//                val firstFeatureProvider =
//                    FirstFeatureExportComponent.Initializer.init(mainToolsProvider)
//                val secondFeatureProvider =
//                    SecondFeatureExportComponent.Initializer.init(mainToolsProvider)
//                val thirdFeatureProvider =
//                    ThirdFeatureExportComponent.Initializer.init(mainToolsProvider)
                return DaggerApplicationComponent.builder()
                    .contextProvider(contextProvider)
//                    .mainToolsProvider(mainToolsProvider)
//                    .firstFeatureProvider(firstFeatureProvider)
//                    .secondFeatureProvider(secondFeatureProvider)
//                    .thirdFeatureProvider(thirdFeatureProvider)
                    .build()
            }
        }
    }
}
