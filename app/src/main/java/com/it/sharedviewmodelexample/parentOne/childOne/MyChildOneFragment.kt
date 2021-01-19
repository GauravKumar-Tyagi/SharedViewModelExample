package com.it.sharedviewmodelexample.parentOne.childOne

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.it.sharedviewmodelexample.R

import com.it.sharedviewmodelexample.parentOne.childOne.subChildOne.SubChildOneFragment
import com.it.sharedviewmodelexample.Base.BaseFragment
import com.it.sharedviewmodelexample.parentOne.MainViewModelOne
import kotlinx.android.synthetic.main.my_child_one_fragment.*


class MyChildOneFragment : BaseFragment() {

    companion object {
        fun newInstance() =
            MyChildOneFragment()
    }

    private lateinit var mviewModel: MyChildOneViewModel

    lateinit var mMainViewModelOne: MainViewModelOne

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v : View =  inflater.inflate(R.layout.my_child_one_fragment, container, false)

        /*************** VM ********************************************************************************/
        // fragment (Fragment Level)
        mviewModel = ViewModelProvider(this).get(MyChildOneViewModel::class.java)
        // fragment.activity (Parent Activity Level)
        mMainViewModelOne = activity?.let { ViewModelProvider(it).get(MainViewModelOne::class.java) } ?: throw Exception("Invalid Activity")
        /*************** VM ********************************************************************************/


        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachObserver()
        click()


    }

    private fun click() {
        idBtn1?.setOnClickListener {
            mMainViewModelOne?.myMessage_From_ChildOne_Fragment("Updated from child fragment : MyChildOneFragment -> MainActivityOne  ")
        }


        idBtn2?.setOnClickListener {
            var fragment = SubChildOneFragment.newInstance()
            myActivity?.addFragment(R.id.idContainer,fragment, "SubChildOneFragment",true)
        }
    }

    private fun attachObserver() {

        mMainViewModelOne?.messageForChildOneFragment?.observe(viewLifecycleOwner, Observer<String> {
            idText?.text = it
        })

    }







}
