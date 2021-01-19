package com.it.sharedviewmodelexample.parentThree

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModelThree : ViewModel() {
    /**************ChildFragment->Activity*******************************/
    val message = MutableLiveData<String>()
    fun myMessage_From_Child_Fragment(msg: String) {
        message.value = msg
    }
    /**************ChildFragment->Activity*******************************/

    /**************Activity->ChildFragment*******************************/
    val messageForActivityToFragment = MutableLiveData<String>()
    fun myMessage_From_Activity_To_Fragment(msg: String) {
        messageForActivityToFragment.value = msg
    }
    /**************Activity->ChildFragment*******************************/

    /**************Fragment->Fragment*******************************/
    val messageForFragmentToFragment = MutableLiveData<String>()
    fun myMessage_From_Fragment_To_Fragment(msg: String) {
        messageForFragmentToFragment.value = msg
    }
    /**************Fragment->Fragment*******************************/
}