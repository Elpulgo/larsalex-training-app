package larsalex.training_app

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class SelectFragment : Fragment() {

    companion object {
        fun newInstance() = SelectFragment()
    }

    private lateinit var viewModel: SelectViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        return inflater.inflate(
                R.layout.select_fragment,
                container,
                false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SelectViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
