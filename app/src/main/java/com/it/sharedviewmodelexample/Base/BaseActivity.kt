package com.it.sharedviewmodelexample.Base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseActivity : AppCompatActivity() {

    fun addFragment(@IdRes viewId: Int, fragment: Fragment, tag: String, backstack: Boolean = true) =
        supportFragmentManager
            .beginTransaction()
            .add(viewId, fragment, tag)
            .apply { if (backstack) addToBackStack(null) }
            .commitAllowingStateLoss()


}