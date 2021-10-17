package ilya.khrushchev.firstfeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.findNavController
import ilya.khrushchev.firstfeature.di.DaggerFirstFeatureComponent
import javax.inject.Inject

class FirstFragment : Fragment() {

    @Inject
    lateinit var firstFeatureApi: FirstFeatureDependencies

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
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val button = view.findViewById<Button>(R.id.to_second_fragment)
        button.setOnClickListener {
            findNavController().navigate(
                firstFeatureApi.navigationCommand.navigateFromFirstToSecond().action
            )
        }
        return view
    }
}
