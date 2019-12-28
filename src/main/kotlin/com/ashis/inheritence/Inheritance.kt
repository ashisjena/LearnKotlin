package com.ashis.inheritence

fun main() {
    val laserPrinter = LaserPrinter("Canon", 10)
    laserPrinter.printModel()
    println(laserPrinter.bestSellingPrice())
}

/*open class Printer() { // class is a public and final by default
}
class LaserPrinter() : Printer()*/

abstract class Printer(val modelName: String) {
    open fun printModel() = println("The model name of the printer is $modelName")
    abstract fun bestSellingPrice(): Double
}

open class LaserPrinter(modelName: String, ppm: Int) : Printer(modelName) {
    final override fun printModel() = println("The model name of the laser printer is $modelName")
    override fun bestSellingPrice(): Double = 10.40
}

class SpecialLaserPrinter(modelName: String) : LaserPrinter(modelName, 15) {
    override fun bestSellingPrice(): Double = 15.99
}

open class Car
class SportsCar : Car {
    constructor() : super()
}

// open data class DataClass(val number: Int) // Data classes can't be open


interface MyInterface {
    val number: Int  // = 50, property initializers are not allowed
    val number2: Int // Concrete implementation of properties
        get() = number * 100
//        get() = field * 100 // Properties in interfaces can't have a backing field

    fun myFunction(str: String): String
}

interface MySubInterface : MyInterface {
    fun mySubFunction(num: Int): String
}

open class Something : MySubInterface {
    override val number: Int = 25
    // override val number2: Int = 50 // Optional
    override fun myFunction(str: String): String = "This is a String: $str"
    override fun mySubFunction(num: Int): String = "This is a num: $num"
}