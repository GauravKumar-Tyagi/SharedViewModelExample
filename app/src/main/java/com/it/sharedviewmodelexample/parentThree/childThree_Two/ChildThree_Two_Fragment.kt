package com.it.sharedviewmodelexample.parentThree.childThree_Two

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.it.sharedviewmodelexample.Base.BaseFragment

import com.it.sharedviewmodelexample.R

import com.it.sharedviewmodelexample.parentThree.MainViewModelThree

import kotlinx.android.synthetic.main.child_three__two__fragment.*

class ChildThree_Two_Fragment : BaseFragment() {

    companion object {
        fun newInstance() = ChildThree_Two_Fragment()
    }

    private lateinit var mviewModel: ChildThreeTwoViewModel
    lateinit var mMainViewModelThree: MainViewModelThree

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v : View =  inflater.inflate(R.layout.child_three__two__fragment, container, false)

        /*************** VM ********************************************************************************/
        // fragment (Fragment Level)
        mviewModel = ViewModelProvider(this).get(ChildThreeTwoViewModel::class.java)
        // fragment.activity (Parent Activity Level)
        mMainViewModelThree = activity?.let { ViewModelProvider(it).get(MainViewModelThree::class.java) } ?: throw Exception("Invalid Activity")
        /*************** VM ********************************************************************************/


        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachObserver()



    }


    private fun attachObserver() {

        mMainViewModelThree?.messageForFragmentToFragment?.observe(viewLifecycleOwner, Observer<String> {
            idUpdatedFromFragment?.text = it
        })

    }

}
