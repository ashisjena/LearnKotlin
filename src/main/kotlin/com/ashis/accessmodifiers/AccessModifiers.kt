package com.ashis.accessmodifiers

import com.ashis.javacode.JavaEmployee

const val MY_CONSTANT = 100

fun main() {
    println(MY_CONSTANT)
    val obj = Demo()
    println(obj)

    val jEmp = JavaEmployee("Ram")
    println(jEmp)
    println(jEmp.firstName)
    println(jEmp.isFullTime)
    val kEmp = KotlinEmployee("Sita", false)
    println(kEmp)
    println(kEmp.firstName)
    println(kEmp.fullTime)
    val kEmp2 = KotlinEmployee2("Gita", false)
    println(kEmp2)
    println(kEmp2.firstName)
    println(kEmp2.fullTime)
    val kEmpz = KotlinEmployeez("Hari", false)
    kEmpz.fullTime = true
    println(kEmpz.firstName)
    println(kEmpz.fullTime)

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

class KotlinEmployeez(val firstName: String, fullTime: Boolean = true) {
    var fullTime = fullTime
        get() {
            println("Running the custom get")
            return field
        }
        set(value) {
            println("Running the custom set")
            field = value
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
