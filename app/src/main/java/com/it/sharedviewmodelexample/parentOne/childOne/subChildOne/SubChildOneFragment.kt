package com.it.sharedviewmodelexample.parentOne.childOne.subChildOne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.it.sharedviewmodelexample.R
import com.it.sharedviewmodelexample.Base.BaseFragment
import com.it.sharedviewmodelexample.parentOne.MainViewModelOne
import kotlinx.android.synthetic.main.sub_child_one_fragment.*

class SubChildOneFragment : BaseFragment() {

    companion object {
        fun newInstance() =
            SubChildOneFragment()
    }



    lateinit var mMainViewModelOne: MainViewModelOne

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v : View =  inflater.inflate(R.layout.sub_child_one_fragment, container, false)

        /*************** VM ********************************************************************************/
        // fragment.activity (Parent Activity Level)
        mMainViewModelOne = activity?.let { ViewModelProvider(it).get(MainViewModelOne::class.java) } ?: throw Exception("Invalid Activity")
        /*************** VM ********************************************************************************/


        return v
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        click()
    }

    private fun click() {
        idClick?.setOnClickListener {
            mMainViewModelOne?.myMessage_From_SubChildTwo_Fragment("Updated from child fragment : SubChildOneFragment -> MyChildOneFragment  ")
        }
        idClick1?.setOnClickListener {
            mMainViewModelOne?.myMessage_From_SubChildTwo_FragmentToActivity("Updated from child fragment : SubChildOneFragment -> MainActivityOne  ")
        }
    }

}
