package ilya.khrushchev.testmultymodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Navigation.findNavController(this, R.id.host_global)
        findNavController(R.id.host_global).navigate(R.id.firstFragment)
    }
}
