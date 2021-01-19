package com.it.sharedviewmodelexample.parentFour.parentFragment

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
import com.it.sharedviewmodelexample.parentFour.childFour_One.ChildFour_One_Fragment
import com.it.sharedviewmodelexample.parentFour.childFour_Two.ChildFour_Two_Fragment
import com.it.sharedviewmodelexample.parentOne.MainViewModelOne
import com.it.sharedviewmodelexample.parentOne.childOne.MyChildOneViewModel
import com.it.sharedviewmodelexample.parentThree.childThree_One.ChildThree_One_Fragment
import com.it.sharedviewmodelexample.parentThree.childThree_Two.ChildThree_Two_Fragment
import kotlinx.android.synthetic.main.activity_main_three.*
import kotlinx.android.synthetic.main.my_parent_fragment.*
import kotlinx.android.synthetic.main.my_parent_fragment.idUpdateFragment1
import kotlinx.android.synthetic.main.my_parent_fragment.idUpdatedFromFragment1

class MyParentFragment : BaseFragment() {

    companion object {
        fun newInstance() = MyParentFragment()
    }

    private lateinit var mviewModel: MyParentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v : View =  inflater.inflate(R.layout.my_parent_fragment, container, false)
        /*************** VM ********************************************************************************/
        // fragment (Fragment Level)
        mviewModel = ViewModelProvider(this).get(MyParentViewModel::class.java)
        /*************** VM ********************************************************************************/

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        attachObserver()
        click()

        /*******************/
        var fragment1 = ChildFour_One_Fragment.newInstance()
        addFragment(R.id.idContainer1,fragment1, "ChildFour_One_Fragment",false)

        var fragment2 = ChildFour_Two_Fragment.newInstance()
        addFragment(R.id.idContainer2,fragment2, "ChildFour_Two_Fragment",false)
        /******************/


    }

    private fun click() {
        idUpdateFragment1?.setOnClickListener {
            mviewModel?.myMessage_From_Parent_Fragment_To_Child_Fragment("Updated Parent Fragment to Child Fragment : MyParentFragment -> ChildFour_One_Fragment  ")
        }
    }

    private fun attachObserver() {
        mviewModel?.message?.observe(viewLifecycleOwner, Observer<String> {
            idUpdatedFromFragment1.text = it
        })
    }

}
