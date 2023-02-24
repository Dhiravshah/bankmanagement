package com.example.bankmanagement.model

import java.util.UUID
class UsersModel: ArrayList<User>()

data class User(
    val id:String=UUID.randomUUID().toString(),
    val firstName:String,
    val lastName: String,
    val email:String,
    val mobile:String,
    val password:String
)

