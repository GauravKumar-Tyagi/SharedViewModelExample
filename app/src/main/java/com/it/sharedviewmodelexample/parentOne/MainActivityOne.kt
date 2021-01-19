package com.it.sharedviewmodelexample.parentOne

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.it.sharedviewmodelexample.Base.BaseActivity
import com.it.sharedviewmodelexample.R
import com.it.sharedviewmodelexample.parentOne.childOne.MyChildOneFragment
import kotlinx.android.synthetic.main.activity_main_one.*

class MainActivityOne : BaseActivity() {

    lateinit var mViewModelOne: MainViewModelOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_one)

        /*************** VM ********************************************************************************/
        // activity (Activity Level)
        mViewModelOne = ViewModelProvider(this).get(MainViewModelOne::class.java)
        /*************** VM ********************************************************************************/

        attachObserver()
        click()
    }

    private fun attachObserver() {
        mViewModelOne?.message?.observe(this, Observer<String> {
            idText1.text = it
        })

        mViewModelOne?.messageForActivity?.observe(this, Observer<String> {
            idText2.text = it
        })
    }

    private fun click() {
        idOpenChildFragment.setOnClickListener {

            var fragment = MyChildOneFragment.newInstance()
            addFragment(R.id.idContainer,fragment, "MyChildOneFragment",true)

        }
    }





}
