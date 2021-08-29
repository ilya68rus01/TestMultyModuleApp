package ilya.khrushchev.core.providers

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component


@Component
interface ContextComponent : ContextProvider {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: Application,
            @BindsInstance context: Context = app
        ): ContextProvider
    }

}
