package larsalex.training_app

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.configuration_fragment.*


class ConfigurationFragment : Fragment() {

    companion object {
        // Used to create a new instance of the class, like some kind of constructor?
        fun newInstance() = ConfigurationFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

         // setupButtonListener()

        return inflater.inflate(
                R.layout.configuration_fragment,
                container,
                false)
    }

    // How to make work in fragment?
//    private fun setupButtonListener(){
//        show_toast_button.setOnClickListener() {
//            Toast.makeText(
//                    activity,
//                    "Laddergoat is impressive!",
//                    Toast.LENGTH_LONG)
//                .show()
//        }
//    }
}
