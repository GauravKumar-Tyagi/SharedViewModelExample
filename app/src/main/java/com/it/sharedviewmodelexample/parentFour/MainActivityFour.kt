package com.it.sharedviewmodelexample.parentFour

import android.os.Bundle
import com.it.sharedviewmodelexample.Base.BaseActivity
import com.it.sharedviewmodelexample.R
import com.it.sharedviewmodelexample.parentFour.parentFragment.MyParentFragment
import kotlinx.android.synthetic.main.activity_main_four.*


class MainActivityFour : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_four)

        idBtn?.setOnClickListener {
            var fragment = MyParentFragment.newInstance()
            addFragment(R.id.idContainer,fragment, "MyParentFragment",true)
        }
    }
}
