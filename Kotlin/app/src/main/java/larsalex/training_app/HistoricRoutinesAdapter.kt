package larsalex.training_app

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.historic_item_row.view.*
import larsalex.training_app.models.History
import java.util.*

class HistoricRoutinesAdapter(
        private val mHistories: ArrayList<History>,
        val context: Context) :
        RecyclerView.Adapter<HistoricRoutinesAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return mHistories.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.historic_item_row, viewGroup, false)
        return ViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemDetailTxt.text = mHistories[i].name
        viewHolder.itemDetailRoutineDetail.text = mHistories[i].routine.name
        viewHolder.itemDetailDate.text = mHistories[i].date.dayOfWeek.toString()
        val duration = mHistories[i].duration.toMinutes().toString() + " minutes"
        viewHolder.itemDetailDuration.text = duration
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemDetailTxt: TextView
        var itemDetailDate: TextView
        var itemDetailRoutineDetail: TextView
        var itemDetailDuration: TextView

        init{
            itemDetailTxt = itemView.txtName
            itemDetailDate =  itemView.txtDate
            itemDetailRoutineDetail = itemView.txtRoutineDetail
            itemDetailDuration = itemView.txtDuration
        }
    }
}