package ilya.khrushchev.thirdfeature.di

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import ilya.khrushchev.thirdfeature.ThirdFragment

@Module
class ThirdFeatureModule {
    @Provides
    fun provideFragment(): () -> Fragment {
        return {
            ThirdFragment()
        }
    }
}