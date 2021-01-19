package com.it.sharedviewmodelexample.parentFour.childFour_One

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
import com.it.sharedviewmodelexample.parentFour.parentFragment.MyParentViewModel
import com.it.sharedviewmodelexample.parentThree.MainViewModelThree
import com.it.sharedviewmodelexample.parentThree.childThree_One.ChildThreeOneViewModel
import kotlinx.android.synthetic.main.child_four__one__fragment.*
import kotlinx.android.synthetic.main.child_three__one__fragment.*
import kotlinx.android.synthetic.main.child_three__one__fragment.idUpdatedToFragment

class ChildFour_One_Fragment : BaseFragment() {

    companion object {
        fun newInstance() = ChildFour_One_Fragment()
    }

    private lateinit var mviewModel: ChildFourOneViewModel

    lateinit var mMyParentViewModel: MyParentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v : View =  inflater.inflate(R.layout.child_four__one__fragment, container, false)

        /*************** VM ********************************************************************************/
        // fragment (Fragment Level)
        mviewModel = ViewModelProvider(this).get(ChildFourOneViewModel::class.java)
        // fragment.parentFragment (Parent Fragment Level)
        mMyParentViewModel = this.parentFragment?.let { ViewModelProvider(it).get(MyParentViewModel::class.java) }
            ?: throw Exception("Invalid Activity")
        /*************** VM ********************************************************************************/


        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachObserver()
        click()


    }

    private fun click() {
        idUpdatedToParentFragment?.setOnClickListener {
            mMyParentViewModel?.myMessage_From_Child_FragmentTo_Parent_Fragment("Updated from child fragment To Parent Fragment : ChildFour_One_Fragment -> MyParentFragment  ")
        }


        idUpdatedToFragment?.setOnClickListener {
            mMyParentViewModel?.myMessage_From_ChildFragment_To_Child_Fragment("Updated from fragment to fragment : ChildFour_One_Fragment -> ChildFour_Two_Fragment  ")
        }
    }

    private fun attachObserver() {

        mMyParentViewModel?.messageFromParentFragmentToChildFragment?.observe(viewLifecycleOwner, Observer<String> {
            idUpdatedFromParentFragment?.text = it
        })

    }


}
