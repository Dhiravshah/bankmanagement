package com.example.bankmanagement

import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.bankmanagement.model.UsersModel
import com.google.gson.Gson

class Authentication {

        private val users: UsersModel = Gson().fromJson(usersFile.readText(), UsersModel::class.java)

    fun Authenticate( email:String, password:String){
        if (email==users[0].email){

            password==users[0].password

        }
    }
}
