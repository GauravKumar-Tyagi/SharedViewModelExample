package com.it.sharedviewmodelexample.parentTwo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModelTwo : ViewModel() {
    /**************ChildFragment->Activity*******************************/
    val message = MutableLiveData<String>()
    fun myMessage_From_ChildOne_Fragment(msg: String) {
        message.value = msg
    }
    /**************ChildFragment->Activity*******************************/



    /**************SubChildActivity->Activity*******************************/
    val messageForActivity = MutableLiveData<String>()
    fun myMessage_From_SubChildTwo_ActivityToActivity(msg: String) {
        messageForActivity.value = msg
    }
    /**************SubChildActivity->Activity*******************************/
}