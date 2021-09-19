package ilya.khrushchev.secondfeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ilya.khrushchev.core.App
import ilya.khrushchev.core.FirstFeatureProvider
import ilya.khrushchev.secondfeature.di.DaggerSecondFeatureComponent

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerSecondFeatureComponent.factory()
            .create(dependencies = SecondFeatureComponentHolder.getComponent())
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}
