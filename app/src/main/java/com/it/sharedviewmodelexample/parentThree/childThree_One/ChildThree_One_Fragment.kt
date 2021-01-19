package com.it.sharedviewmodelexample.parentThree.childThree_One

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

import com.it.sharedviewmodelexample.parentOne.childOne.subChildOne.SubChildOneFragment
import com.it.sharedviewmodelexample.parentThree.MainViewModelThree
import kotlinx.android.synthetic.main.child_three__one__fragment.*


class ChildThree_One_Fragment : BaseFragment() {

    companion object {
        fun newInstance() = ChildThree_One_Fragment()
    }

    private lateinit var mviewModel: ChildThreeOneViewModel
    lateinit var mMainViewModelThree: MainViewModelThree
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v : View =  inflater.inflate(R.layout.child_three__one__fragment, container, false)

        /*************** VM ********************************************************************************/
        // fragment (Fragment Level)
        mviewModel = ViewModelProvider(this).get(ChildThreeOneViewModel::class.java)
        // fragment.activity (Parent Activity Level)
        mMainViewModelThree = activity?.let { ViewModelProvider(it).get(MainViewModelThree::class.java) } ?: throw Exception("Invalid Activity")
        /*************** VM ********************************************************************************/


        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachObserver()
        click()


    }

    private fun click() {
        idUpdatedToActivity?.setOnClickListener {
            mMainViewModelThree?.myMessage_From_Child_Fragment("Updated from child fragment : ChildThree_One_Fragment -> MainActivityThree  ")
        }


        idUpdatedToFragment?.setOnClickListener {
           mMainViewModelThree?.myMessage_From_Fragment_To_Fragment("Updated from fragment to fragment : ChildThree_One_Fragment -> ChildThree_Two_Fragment  ")
        }
    }

    private fun attachObserver() {

        mMainViewModelThree?.messageForActivityToFragment?.observe(viewLifecycleOwner, Observer<String> {
            idUpdatedFromActivity?.text = it
        })

    }

}
