package ilya.khrushchev.firstfeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ilya.khrushchev.firstfeature.di.DaggerFirstFeatureComponent
import ilya.khrushchev.firstfeature.navigation.FirstFeatureNavCommandProvider
import javax.inject.Inject

class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFirstFeatureComponent
            .factory()
            .create(
                deps = FirstFeatureComponentHolder.getComponent()
            )
            .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
}
