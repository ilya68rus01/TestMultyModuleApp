package ilya.khrushchev.firstfeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ilya.khrushchev.core.App

class FirstFragment : Fragment() {

    fun inject() {
        FirstFeatureComponent.Initializer.init(
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
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
}