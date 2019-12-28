package com.ashis.ifloopswitchtrycatch

import java.math.BigDecimal

fun main() {
    val num = 410
    val y = 10

    when (num) {
        100 -> println("100")
        200, 250 -> println("200 or 250")
        in 300..399 -> println("in the range of 300 to 399")
        y + 400 -> println("${y + 400}")
        else -> println("Doesn't match anything")
    }

    val obj1: Any = "This is a String"
    val obj2: Any = BigDecimal(10.35)
    val obj3: Any = 50

    val someObj: Any = obj2

    val z = when (someObj) {
        is String -> println(someObj.toUpperCase())
        is BigDecimal -> println(someObj.remainder(BigDecimal(5.5)))
        is Int -> println(someObj * 15)
        else -> println("I've no idea what type it is!")
    }
    println(z) // Unit, as when expression doesn't return any value

    val timeOfYear = Season.WINTER
    val str = when (timeOfYear) { // else is not needed as the compiler know we have covered all the enum types
        Season.SPRING -> "Flowers are blooming"
        Season.WINTER -> "I need a coat"
        Season.SUMMER -> "It's Hot"
        Season.FALL -> "It's getting cooler"
    }
    println(str)

    val num1 = 10
    val num2 = 50

    when {
        num1 > num2 -> println("num1 is greater than num2")
        num2 > num1 -> println("num2 is greater than num1")
        else -> println("num1 is equal to num2")
    }
}

enum class Season {
    SPRING, SUMMER, FALL, WINTER
}