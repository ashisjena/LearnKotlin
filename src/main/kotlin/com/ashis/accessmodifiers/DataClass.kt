package com.ashis.accessmodifiers

fun main() {
    val car1 = Car("Blue", "Toyota", 2019)
    println(car1)
    val car2 = Car("Blue", "Toyota", 2019)
    println(car1 == car2) // == is .equals() and === is reference equality check
    val car3 = car1.copy(year = 2015, color = "Green")
    println(car3)
}

data class Car(val color: String, val make: String, val year: Short)