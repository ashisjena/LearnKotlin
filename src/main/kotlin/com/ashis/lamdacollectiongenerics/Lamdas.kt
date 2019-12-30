package com.ashis.lamdacollectiongenerics

import java.util.*

fun main() {
    run { println("I'm in a lambda!") }

    val employees = arrayListOf(Employee("John", "Smith", 2012),
            Employee("Jane", "Wilson", 2020),
            Employee("Mike", "Monegan", 2010),
            Employee("Marry", "Johnson", 2000))

    println(employees.minBy { e -> e.startYear })
    println(employees.minBy { it.startYear })
    println(employees.minBy(Employee::startYear))

    var num = 10
    run {
        num += 15
        println(num)
    }

    println(countTo50())
    println(countTo60())
    println(countTo55())

    findByLastName(employees, "Wilson")

    employees.forEach label@{
        if (it.startYear == 2000) {
            // return@forEach // either this return or the below return only will return from the lambda. Otherwise it will return from the enclosed function.
            return@label
            // return  // This will return from main function
        }

    }

    "Some String".apply label@{
        "Another String".apply {
            println(toLowerCase())
            println(this@label.toUpperCase())
        }
    }
}

fun countTo50(): String {
    val numbers = StringJoiner(", ")
    (1..50).forEach { numbers.add(it.toString()) }
    return numbers.toString()
}

fun countTo60(): String = with(StringJoiner(", ")) {
    (1..60).forEach { this.add(it.toString()) }
    this.toString()
}

fun countTo55(): String = StringJoiner(", ").apply {
    (1..55).forEach { this.add(it.toString()) }
}.toString()

fun findByLastName(employees: List<Employee>, lastName: String) {
    employees.forEach {
        if (it.lastName == lastName) {
            println("Yes, there's an employee with the last name $lastName")
            return
        }
    }

    println("Nope, there's no employee with the last name $lastName")
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int)