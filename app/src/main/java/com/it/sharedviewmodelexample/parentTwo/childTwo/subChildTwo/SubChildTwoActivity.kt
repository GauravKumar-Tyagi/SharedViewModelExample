package com.it.sharedviewmodelexample.parentTwo.childTwo.subChildTwo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.it.sharedviewmodelexample.Base.BaseActivity
import com.it.sharedviewmodelexample.R
import kotlinx.android.synthetic.main.activity_sub_child_two.*


class SubChildTwoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_child_two)

        // Retrieve the parameter.
        val param = intent.getIntExtra("myParam",-1)
        Log.e("~~~!!~!",""+param)


        // Build a result intent and post it back.


        idClick?.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("myResult", "Okay...")
            resultIntent.putExtra("num", 1)
            setResult(Activity.RESULT_OK, resultIntent)
            //finish()
        }

        idClick1?.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("myResult", "Okay...")
            resultIntent.putExtra("num", 2)
            setResult(Activity.RESULT_OK, resultIntent)
            //finish()
        }

    }
}
