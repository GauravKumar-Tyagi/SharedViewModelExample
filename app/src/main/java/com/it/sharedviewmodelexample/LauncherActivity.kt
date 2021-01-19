package com.it.sharedviewmodelexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.it.sharedviewmodelexample.Base.BaseActivity
import com.it.sharedviewmodelexample.parentFour.MainActivityFour
import com.it.sharedviewmodelexample.parentOne.MainActivityOne
import com.it.sharedviewmodelexample.parentThree.MainActivityThree
import com.it.sharedviewmodelexample.parentTwo.MainActivityTwo
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : BaseActivity() {
    /**
     * There are only 4 ways to use ViewModels in total ::
     * 1. activity
     * 2. fragment
     * 3. fragment.activity
     * 4. fragment.parentFragment
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        /**
         * ViewModel with ::
         * activity
         * fragment
         * fragment.activity
         */
        idBtn1?.setOnClickListener {
            startActivity(Intent(this, MainActivityOne::class.java))
        }
        /**
         * ViewModel with ::
         * activity
         * fragment
         * activity
         */
        idBtn2?.setOnClickListener {
            startActivity(Intent(this, MainActivityTwo::class.java))
        }

        /**
         * ViewModel with ::
         * activity
         * fragment
         * fragment.activity
         */
        idBtn3?.setOnClickListener{
            startActivity(Intent(this, MainActivityThree::class.java))
        }

        /**
         * ViewModel with ::
         * fragment.parentFragment
         * fragment
         * fragment.activity
         */
        idBtn4?.setOnClickListener {
            startActivity(Intent(this, MainActivityFour::class.java))
        }


        /**
         * This concept is same for view-pager also you can implement same concept for view-pager also.
         */


    }
}
