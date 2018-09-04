package com.example.lefter.tobedeleted

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import org.jetbrains.anko.doAsync

class UserViewModel(): ViewModel() {
    val jsonApi: JsonApi = JsonApi.getInstance()
    val userItems: MutableLiveData<ArrayList<UserModel>> = MutableLiveData()

    fun downloadUsers(){
        doAsync {
            jsonApi.getUsers().subscribe({
                for(c in it){
                    Log.v("dumdee", c.email)
                }
                userItems.postValue(it as ArrayList<UserModel>)
            },{
                throw it
                Log.v("ERRORssss", "ERROR")
            })
        }

    }

}