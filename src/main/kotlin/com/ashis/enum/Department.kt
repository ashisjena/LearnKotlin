package com.ashis.enum

fun main() {
    println(Department.FINANCE.getDeptInfo())
    println(Department.HR.fullName)
}

enum class Department(val fullName: String, val empCount: Int) {
    HR("Human Resources", 5), IT("Information Technology", 10),
    FINANCE("Finance", 3), SALES("Sales", 20); // Semicolon is necessary in-case we want to add fun in enum

    fun getDeptInfo() = "The $fullName department has $empCount employees"
}