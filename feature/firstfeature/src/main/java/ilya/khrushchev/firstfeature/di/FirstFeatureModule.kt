package ilya.khrushchev.firstfeature.di

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import ilya.khrushchev.firstfeature.FirstFragment

@Module
class FirstFeatureModule {

    @Provides
    fun provideFragment(): () -> Fragment {
        return {
            FirstFragment()
        }
    }

}
