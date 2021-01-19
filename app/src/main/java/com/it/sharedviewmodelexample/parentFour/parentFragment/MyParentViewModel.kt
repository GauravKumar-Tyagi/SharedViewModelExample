package com.it.sharedviewmodelexample.parentFour.parentFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyParentViewModel : ViewModel() {
    /**************ChildFragment->ParentFragment*******************************/
    val message = MutableLiveData<String>()
    fun myMessage_From_Child_FragmentTo_Parent_Fragment(msg: String) {
        message.value = msg
    }
    /**************ChildFragment->ParentFragment*******************************/

    /**************ParentFragment->ChildFragment*******************************/
    val messageFromParentFragmentToChildFragment = MutableLiveData<String>()
    fun myMessage_From_Parent_Fragment_To_Child_Fragment(msg: String) {
        messageFromParentFragmentToChildFragment.value = msg
    }
    /**************ParentFragment->ChildFragment*******************************/

    /**************Fragment->Fragment*******************************/
    val messageFromChildFragmentToChildFragment = MutableLiveData<String>()
    fun myMessage_From_ChildFragment_To_Child_Fragment(msg: String) {
        messageFromChildFragmentToChildFragment.value = msg
    }
    /**************Fragment->Fragment*******************************/
}
