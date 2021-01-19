package com.it.sharedviewmodelexample.parentThree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.it.sharedviewmodelexample.Base.BaseActivity
import com.it.sharedviewmodelexample.R
import com.it.sharedviewmodelexample.parentOne.MainViewModelOne
import com.it.sharedviewmodelexample.parentOne.childOne.MyChildOneFragment
import com.it.sharedviewmodelexample.parentThree.childThree_One.ChildThree_One_Fragment
import com.it.sharedviewmodelexample.parentThree.childThree_Two.ChildThree_Two_Fragment
import kotlinx.android.synthetic.main.activity_main_one.*
import kotlinx.android.synthetic.main.activity_main_three.*

class MainActivityThree : BaseActivity() {

    lateinit var mViewModelThree: MainViewModelThree

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_three)

        /*************** VM ********************************************************************************/
        // activity (Activity Level)
        mViewModelThree = ViewModelProvider(this).get(MainViewModelThree::class.java)
        /*************** VM ********************************************************************************/

        attachObserver()
        click()

        /*******************/
        var fragment1 = ChildThree_One_Fragment.newInstance()
        addFragment(R.id.idContainer1,fragment1, "ChildThree_One_Fragment",false)

        var fragment2 = ChildThree_Two_Fragment.newInstance()
        addFragment(R.id.idContainer2,fragment2, "ChildThree_Two_Fragment",false)
        /******************/
    }

    private fun click() {
        idUpdateFragment1?.setOnClickListener {
           mViewModelThree?.myMessage_From_Activity_To_Fragment("Updated Activity to Fragment : MainActivityThree -> ChildThree_One_Fragment  ")
        }
    }

    private fun attachObserver() {
        mViewModelThree?.message?.observe(this, Observer<String> {
            idUpdatedFromFragment1.text = it
        })
    }
}
