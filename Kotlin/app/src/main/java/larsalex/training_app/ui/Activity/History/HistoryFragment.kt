package larsalex.training_app.ui.Activity.History

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.history_fragment.*
import kotlinx.android.synthetic.main.history_fragment.view.*
import larsalex.training_app.HistoricRoutinesAdapter
import larsalex.training_app.R
import larsalex.training_app.Routine
import larsalex.training_app.models.History
import java.time.Duration
import java.time.LocalDateTime.now


class HistoryFragment : Fragment() {

    private val mHistories: ArrayList<History> = ArrayList()

    companion object {
        fun newInstance() = HistoryFragment()
    }

    private lateinit var viewModel: HistoryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.history_fragment, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this.activity!!, R.layout.history_fragment)
        val layoutManager = LinearLayoutManager(this.activity)
        binding.root.recycle_view_historic_routines.layoutManager = layoutManager

        // val sessions = SessionMock
        // TODO: Make new adapter with name from below, and mock sessions!!
        // TODO: Fix the adapter after this example, with the new bindings: https://github.com/irontec/android-mvvm-example/blob/master/app/src/main/java/com/irontec/axier/mvvmexample/view/MainActivity.kt

        //  val adapter = HistoryAdapter(sessions)
        //  binding.root.recycle_view_historic_routines.adapter = adapter

        addDummyHistories()

        recycle_view_historic_routines!!.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)

        val adapter = HistoricRoutinesAdapter(mHistories, this.context!!)

        recycle_view_historic_routines!!.adapter = adapter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addDummyHistories() {
        for (i in 0..7) {
            mHistories.add(
                    History(
                            "Basic routine",
                            Duration.ofMinutes(i.toLong()),
                            Routine("Push up + squats"),
                            now().minusDays(i.toLong())))
        }
    }
}
