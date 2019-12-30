package com.ashis.lamdacollectiongenerics

fun main() {
    val immutableMap = mapOf(1 to Car("Green", "Toyota", 2015),
            2 to Car("White", "Honda", 2019),
            3 to Car("Black", "Mercedes", 2020))
    println(immutableMap.javaClass)
    println(immutableMap)

    val mutableMap = mutableMapOf<String, Car>("Ashis's Car" to Car("Red", "Lexus", 2020),
            "Ram's Car" to Car("White", "Mercedes", 2018))
    println(mutableMap.javaClass)
    println(immutableMap)

    val mutableMap2 = hashMapOf<Int, Car>(1 to Car("White", "Hyundai", 2018))
    println(mutableMap2.javaClass)
    mutableMap2.put(3, Car("Brown", "Land Rover", 2000))
    mutableMap2[4] = Car("Blue", "Ford", 2014)
    println(mutableMap2)

    val mapObj = mutableMap2.plus(2 to Car("Red", "Ferrari", 2015)) // returns a new immutable map
    println(mapObj.javaClass)
    println(mapObj)

    val pair = Pair(10, Car("White", "Maruti", 1999))
    val (firstValue, secondValue) = pair
    println("$firstValue, $secondValue")
    println(mapObj.plus(pair))

    for ((k, v) in mapObj) {
        println("$k, $v")
    }

    val car = Car("Blue", "Covette", 1959)
    val (color, model, year) = car // For destructuring you need to implement the component methods.
    println("$color, $model, $year")
}

class Car(val color: String, val make: String, val year: Int) { // data class by default implements component functions.
    operator fun component1() = color
    operator fun component2() = make
    operator fun component3() = year
}