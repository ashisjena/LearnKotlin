package com.ashis.functions

fun main() {
    abc2()
    println(labelMultiply(3, 4, "This result is:"))
    println(labelMultiply(2, 6))
    println(labelMultiply(label = "Here's the result:", operand2 = 2, operand1 = 6))

    val emp = Employee("Ram")
    println(emp.upperCaseFirstName())

    val car1 = Car("Toyota", "Green", 2017)
    val car2 = Car("Toyota", "White", 2019)
    val car3 = Car("Toyota", "Blue", 2020)
    printColors(car1, car2, car3, emp = emp)
    printColors2(emp, car1, car2, car3)

    val manyCars = arrayOf(car1, car2, car3)
    printColors2(emp, *manyCars) // The * is the spread operator here.

    val moreCars = arrayOf(car2, car3)
    val car4 = car2.copy()
    val lotsOfCar = arrayOf(*manyCars, *moreCars, car4)
    lotsOfCar.forEach(::println)

    println(Utils().upperFirstAndLast("this is all in lowercase"))
    println("this is all in lowercase".upperFirstAndLast())
    inlineExample()
}

inline fun inlineExample() { // The function body gets replaced in the byte code. The JVM decides whether to inline the function or not to boost performance
    println("This is kotlin inline function example")
}

fun String.upperFirstAndLast(): String { // In extension function we can invoke the public methods of the Receiver type
    val upperFirst = substring(0, 1).toUpperCase() + substring(1)
    return upperFirst.substring(0, upperFirst.length - 1) + upperFirst.substring(upperFirst.length - 1, upperFirst.length).toUpperCase()
}

fun abc(): Unit {} // Default return type of any function is Unit. It is equivalent to void
fun abc2(): Unit = println("abc2 function")

fun labelMultiply(operand1: Int, operand2: Int, label: String = "The answer is:") = ("$label ${operand1 * operand2}") // Expression body function
/*
fun labelMultiply(operand1: Int, operand2: Int, label: String): String {  // Block body function
    return ("$label ${operand1 * operand2}")
}*/

class Employee(private val firstName: String) {
    fun upperCaseFirstName() = firstName.toUpperCase()
}

fun printColors(vararg cars: Car, emp: Employee) { // vararg function can only have one vararg argument. And can't have multiple vararg arguments.
    cars.forEach {
        println(it.color)
    }
    println(emp)
}

fun printColors2(emp: Employee, vararg cars: Car) { // using vararg as the last operand, we no need to mention the value-parameter during function invocation
    cars.forEach {
        println(it.color)
    }
    println(emp)
}

data class Car(val make: String, val color: String, val year: Int)