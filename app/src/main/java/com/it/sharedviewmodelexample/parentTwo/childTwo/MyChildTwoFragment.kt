package com.it.sharedviewmodelexample.parentTwo.childTwo

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.it.sharedviewmodelexample.Base.BaseFragment
import com.it.sharedviewmodelexample.R
import com.it.sharedviewmodelexample.parentTwo.MainViewModelTwo
import com.it.sharedviewmodelexample.parentTwo.childTwo.subChildTwo.SubChildTwoActivity
import kotlinx.android.synthetic.main.my_child_two_fragment.*


class MyChildTwoFragment : BaseFragment() {

    companion object {
        val CHILD_ACTIVITY_REQUEST_CODE = 0
        fun newInstance() = MyChildTwoFragment()
    }

    private lateinit var mviewModel: MyChildTwoViewModel
    lateinit var mMainViewModelTwo: MainViewModelTwo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v : View =  inflater.inflate(R.layout.my_child_two_fragment, container, false)

        /*************** VM ********************************************************************************/
        // fragment (Fragment Level)
        mviewModel = ViewModelProvider(this).get(MyChildTwoViewModel::class.java)
        // fragment.activity (Parent Activity Level)
        mMainViewModelTwo = activity?.let { ViewModelProvider(it).get(MainViewModelTwo::class.java) } ?: throw Exception("Invalid Activity")
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
            mMainViewModelTwo?.myMessage_From_ChildOne_Fragment("Updated from child fragment : MyChildTwoFragment -> MainActivityTwo  ")
        }


        idBtn2?.setOnClickListener {
            var intent = Intent(this.activity, SubChildTwoActivity::class.java)
            intent.putExtra("myParam", 45)
            startActivityForResult(intent,CHILD_ACTIVITY_REQUEST_CODE)
        }
    }

    private fun attachObserver() {



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                //super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === CHILD_ACTIVITY_REQUEST_CODE) {
            if (resultCode === RESULT_OK) { // Get result from the result intent.
                val result : String  = data!!.getStringExtra("myResult")
                var num : Int = data!!.getIntExtra("num",0)
                // Do something with result...
                if(num==1){
                    idText?.text = result
                }else if(num==2){
                    idText?.text = result
                    mMainViewModelTwo?.myMessage_From_SubChildTwo_ActivityToActivity("Updated from sub child fragment : SubChildTwoActivity -> MainActivityTwo  ")
                }
            }
        }

    }




}
