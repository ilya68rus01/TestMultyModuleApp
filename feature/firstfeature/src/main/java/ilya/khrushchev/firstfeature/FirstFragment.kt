package ilya.khrushchev.firstfeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.net.toUri
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.findNavController
import ilya.khrushchev.firstfeature.di.DaggerFirstFeatureComponent
import javax.inject.Inject
import androidx.navigation.fragment.NavHostFragment

import androidx.navigation.NavDeepLinkRequest




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
            val request = NavDeepLinkRequest.Builder
                .fromUri("http://www.test.link/second".toUri())
                .build()
            findNavController().navigate(request)
        }
        val toThirdButton = view.findViewById<Button>(R.id.to_third_fragment)
        toThirdButton.setOnClickListener {
            val request = NavDeepLinkRequest.Builder
                .fromUri("http://test.link.fragment/third".toUri())
                .build()
            findNavController().navigate(request)
        }
        return view
    }
}
