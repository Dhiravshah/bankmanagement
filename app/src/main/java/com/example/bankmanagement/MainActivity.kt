package com.example.bankmanagement


import com.example.bankmanagement.Utils.ConsoleColors
import com.example.bankmanagement.model.User
import com.example.bankmanagement.model.UsersModel
import java.io.File
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.regex.Pattern

val usersFile =
    File("C:\\Users\\158336\\AndroidStudioProjects\\BankManagement\\app\\src\\main\\java\\com\\example\\bankmanagement\\Json\\Users.json")

fun main() {
    val users = Gson().fromJson(usersFile.readText(), UsersModel::class.java)
    var fn = ""
    var ln = ""
    var mob = ""
    var email = ""
    var password = ""
    if (users.size == 0) {
        println(ConsoleColors.ConsoleColors.BLACK_BACKGROUND + "\t\t\tRegister Admin:\t\t\t" + ConsoleColors.ConsoleColors.RESET)
        print(ConsoleColors.ConsoleColors.PURPLE_BACKGROUND + "First name:" + ConsoleColors.ConsoleColors.RESET)

        while (fn == "") {
            val f: String = readln()
            if (!f.isNullOrBlank()) {
                fn = f
            } else {
//                error(ConsoleColors.ConsoleColors.RED_BACKGROUND+"Enter the First Name:"+ ConsoleColors.ConsoleColors.RESET)
                println(ConsoleColors.ConsoleColors.RED_BACKGROUND + "Enter the First Name:" + ConsoleColors.ConsoleColors.RESET)
            }
        }
        println()
        print(ConsoleColors.ConsoleColors.PURPLE_BACKGROUND + "Last name:" + ConsoleColors.ConsoleColors.RESET)

        while (ln == "") {
            val l: String = readln()
            if (!l.isNullOrBlank()) {
                ln = l
            } else {
                println(ConsoleColors.ConsoleColors.RED_BACKGROUND + "Enter the Last Name:" + ConsoleColors.ConsoleColors.RESET)
            }
        }
        println()
        print(ConsoleColors.ConsoleColors.PURPLE_BACKGROUND + "Mobile Number:" + ConsoleColors.ConsoleColors.RESET)

        while (mob == "") {
            val mn: String = readln()
            if (mn.length < 10) {
                println(ConsoleColors.ConsoleColors.RED_BACKGROUND + "Enter the valid Mobile Number" + ConsoleColors.ConsoleColors.RESET)
            } else {
                mob = mn
            }
        }
        println()
        print(ConsoleColors.ConsoleColors.PURPLE_BACKGROUND + "Email:" + ConsoleColors.ConsoleColors.RESET)

        while (email == "") {
            val em: String = readln()
            if (!(em.isNullOrBlank()) && Pattern.compile(".+@.+\\.[a-z]+").matcher(em).matches()) {
                email = em
            } else {
                println(ConsoleColors.ConsoleColors.RED_BACKGROUND + "Enter the valid Email" + ConsoleColors.ConsoleColors.RESET)

            }
        }
        println()
        print(ConsoleColors.ConsoleColors.PURPLE_BACKGROUND + "Password:" + ConsoleColors.ConsoleColors.RESET)

        while (password == "") {
            val pwd: String = readln()
            if (pwd.length < 9) {
                println(ConsoleColors.ConsoleColors.RED_BACKGROUND + "Password length must be greater than or equal to 8" + ConsoleColors.ConsoleColors.RESET)
            } else {
                password = pwd
            }
        }
    }
    else
    {
        println(ConsoleColors.ConsoleColors.BLACK_BACKGROUND + "\t\t\tLogin to Enter:\t\t\t" + ConsoleColors.ConsoleColors.RESET)
        println(ConsoleColors.ConsoleColors.BLACK_BACKGROUND + "\t\t\tENter the Email:\t\t\t" + ConsoleColors.ConsoleColors.RESET)

    }
    val u = User(firstName = fn, lastName = ln, email = email, mobile = mob, password = password)
    users.add(u)
    usersFile.writeText(GsonBuilder().setPrettyPrinting().create().toJson(users))

}
