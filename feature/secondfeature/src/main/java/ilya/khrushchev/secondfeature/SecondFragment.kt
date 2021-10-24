package ilya.khrushchev.secondfeature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
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
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        view.findViewById<Button>(R.id.to_first_fragment).setOnClickListener {
            val request = NavDeepLinkRequest.Builder
                .fromUri("http://test.link.fragment/first".toUri())
                .build()
            findNavController().navigate(request)
        }
        view.findViewById<Button>(R.id.to_third_fragment).setOnClickListener {
            val request = NavDeepLinkRequest.Builder
                .fromUri("android-app://test.link.fragment/third".toUri())
                .build()
            findNavController().navigate(request)
        }
        return view
    }
}
