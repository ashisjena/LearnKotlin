package com.ashis.accessmodifiers

import com.ashis.javacode.JavaEmployee

fun main() {
    val obj = Demo()
    println(obj)

    val jEmp = JavaEmployee("Ram")
    println(jEmp)
    println(jEmp.firstName)
    println(jEmp.isFullTime)
    val kEmp = KotlinEmployee2("Sita", false)
    println(kEmp)
    println(kEmp.firstName)
    println(kEmp.fullTime)

    println(Demo2().dummy)
}

private class Demo

class Demo2 {
    val dummy: String

    constructor() {
        this.dummy = "Hello"
    }
}

class KotlinEmployee(val firstName: String, val fullTime: Boolean = true) {
    override fun toString(): String {
        return "KotlinEmployee(firstName='$firstName', fullTime=$fullTime)"
    }
}

class KotlinEmployee2(val firstName: String) {
    var fullTime: Boolean = true

    constructor(firstName: String, fullTime: Boolean) : this(firstName) {
        this.fullTime = fullTime
    }
}

//class KotlinEmployee2 protected constructor(val firstName: String)

/*
class KotlinEmployeeVerbose constructor(firstName: String) {
    val firstName: String

    init {
        this.firstName = firstName
    }

    // val firstName: String = firstName
}*/
