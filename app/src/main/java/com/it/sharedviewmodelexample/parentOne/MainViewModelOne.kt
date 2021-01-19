package com.it.sharedviewmodelexample.parentOne

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModelOne : ViewModel() {
    /**************ChildFragment->Activity*******************************/
    val message = MutableLiveData<String>()
    fun myMessage_From_ChildOne_Fragment(msg: String) {
        message.value = msg
    }
    /**************ChildFragment->Activity*******************************/

    /**************SubChildFragment->ChildFragment*******************************/
    val messageForChildOneFragment = MutableLiveData<String>()
    fun myMessage_From_SubChildTwo_Fragment(msg: String) {
        messageForChildOneFragment.value = msg
    }
    /**************SubChildFragment->ChildFragment*******************************/

    /**************SubChildFragment->Activity*******************************/
    val messageForActivity = MutableLiveData<String>()
    fun myMessage_From_SubChildTwo_FragmentToActivity(msg: String) {
        messageForActivity.value = msg
    }
    /**************SubChildFragment->Activity*******************************/
}