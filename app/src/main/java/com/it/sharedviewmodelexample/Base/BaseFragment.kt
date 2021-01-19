package com.it.sharedviewmodelexample.Base

import android.content.Context
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.it.sharedviewmodelexample.Base.BaseActivity

open class BaseFragment : Fragment() {

    protected var myActivity: BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) this.myActivity = context
    }

    fun addFragment(@IdRes viewId: Int, fragment: Fragment, tag: String, backstack: Boolean = true) =
        childFragmentManager
            .beginTransaction()
            .add(viewId, fragment, tag)
            .apply { if (backstack) addToBackStack(null) }
            .commitAllowingStateLoss()
}