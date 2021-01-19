package com.it.sharedviewmodelexample.parentFour.childFour_Two

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
import com.it.sharedviewmodelexample.parentFour.childFour_One.ChildFourOneViewModel
import com.it.sharedviewmodelexample.parentFour.parentFragment.MyParentViewModel
import kotlinx.android.synthetic.main.child_four__one__fragment.*
import kotlinx.android.synthetic.main.child_four__one__fragment.idUpdatedToFragment
import kotlinx.android.synthetic.main.child_four__two__fragment.*
import kotlinx.android.synthetic.main.child_three__one__fragment.*

class ChildFour_Two_Fragment : BaseFragment() {

    companion object {
        fun newInstance() = ChildFour_Two_Fragment()
    }

    private lateinit var mviewModel: ChildFourTwoViewModel

    lateinit var mMyParentViewModel: MyParentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v : View = inflater.inflate(R.layout.child_four__two__fragment, container, false)

        /*************** VM ********************************************************************************/
        // fragment (Fragment Level)
        mviewModel = ViewModelProvider(this).get(ChildFourTwoViewModel::class.java)
        // fragment.parentFragment (Parent Fragment Level)
        mMyParentViewModel = this.parentFragment?.let { ViewModelProvider(it).get(MyParentViewModel::class.java) }
            ?: throw Exception("Invalid Activity")
        /*************** VM ********************************************************************************/

        return v
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachObserver()



    }



    private fun attachObserver() {

        mMyParentViewModel?.messageFromChildFragmentToChildFragment?.observe(viewLifecycleOwner, Observer<String> {
            idUpdatedFromFragment?.text = it
        })

    }



}
