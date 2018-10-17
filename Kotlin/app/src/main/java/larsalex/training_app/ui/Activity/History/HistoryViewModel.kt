package larsalex.training_app.ui.Activity.History

import android.annotation.SuppressLint
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Build
import android.support.annotation.RequiresApi
import larsalex.training_app.models.Session
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import java.util.concurrent.TimeUnit


class HistoryViewModel(
        private val mSession: Session,
        private val mTitle: String,
        private val mDetail: String
) : BaseObservable() {
    val formattedDate: String
        @Bindable
        get() {
            val simpleDateFormat = SimpleDateFormat(
                    "EEE, d MMM yyyy HH:mm",
                    Locale.getDefault())

            return simpleDateFormat.format(mSession.start)
        }

    val duration: String
        @SuppressLint("NewApi")
        @Bindable
        get() {

            var diff = calculateTimeDiffInSeconds(
                    mSession.start,
                    mSession.end
            )

            return String.format("%d min %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(diff),
                    TimeUnit.MILLISECONDS.toSeconds(diff) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff)))
        }

    val name: String
        @Bindable
        get() = mTitle

    val detail: String
        @Bindable
        get()= mDetail

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateTimeDiffInSeconds(
            start: LocalDateTime,
            end: LocalDateTime
    ): Long {
        var msSinceEpochStart = start
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli()

        var msSinceEpochEnd = end
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli()

        return msSinceEpochEnd - msSinceEpochStart
    }
}
