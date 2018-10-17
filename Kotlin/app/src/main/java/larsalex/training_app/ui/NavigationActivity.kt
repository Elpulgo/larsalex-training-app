package larsalex.training_app

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_activity -> {
                val activityFragment = ActivityFragment.newInstance()
                launchFragment(activityFragment, "Next up")
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_select -> {
                val selectFragment = SelectFragment.newInstance()
                launchFragment(selectFragment, "Select")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val activityFragment = ActivityFragment.newInstance()
        launchFragment(activityFragment, "Next up")
    }

    // @TODO: Refactor this to some kind of utility class?? Seems like a usual scenario in the lifecycle
    private fun launchFragment(fragment: Fragment, name: String){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

        title = name
    }
}
