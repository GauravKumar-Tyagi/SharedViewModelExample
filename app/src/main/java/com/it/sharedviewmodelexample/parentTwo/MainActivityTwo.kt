package com.it.sharedviewmodelexample.parentTwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.it.sharedviewmodelexample.Base.BaseActivity
import com.it.sharedviewmodelexample.R
import com.it.sharedviewmodelexample.parentOne.MainViewModelOne
import com.it.sharedviewmodelexample.parentOne.childOne.MyChildOneFragment
import com.it.sharedviewmodelexample.parentTwo.childTwo.MyChildTwoFragment
import kotlinx.android.synthetic.main.activity_main_two.*

class MainActivityTwo : BaseActivity() {

    lateinit var mViewModelTwo: MainViewModelTwo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_two)

        /*************** VM ********************************************************************************/
        // activity (Activity Level)
        mViewModelTwo = ViewModelProvider(this).get(MainViewModelTwo::class.java)
        /*************** VM ********************************************************************************/

        attachObserver()
        click()
    }


    private fun attachObserver() {
        mViewModelTwo?.message?.observe(this, Observer<String> {
            idText1.text = it
        })
        mViewModelTwo?.messageForActivity.observe(this, Observer<String> {
            idText2.text = it
        })

    }

    private fun click() {
        idOpenChildFragment.setOnClickListener {

            var fragment = MyChildTwoFragment.newInstance()
            addFragment(R.id.idContainer,fragment, "MyChildTwoFragment",true)

        }
    }


}
