package larsalex.training_app

import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.history_fragment.*
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
        viewModel = ViewModelProviders.of(this).get(HistoryViewModel::class.java)

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
