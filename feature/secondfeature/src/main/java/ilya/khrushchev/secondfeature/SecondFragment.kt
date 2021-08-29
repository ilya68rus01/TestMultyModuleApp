package ilya.khrushchev.secondfeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ilya.khrushchev.core.App
import ilya.khrushchev.core.FirstFeatureProvider

class SecondFragment : Fragment() {

    fun inject() {
        SecondFeatureComponent.Initializer.init(
            (context?.applicationContext as App).getAppComponent()
        ).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}