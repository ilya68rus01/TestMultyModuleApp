package ilya.khrushchev.secondfeature.di

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import ilya.khrushchev.secondfeature.SecondFragment

@Module
class SecondFeatureModule {

    @Provides
    fun provideFragment(): () -> Fragment {
        return {
            SecondFragment()
        }
    }
}