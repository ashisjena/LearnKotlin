package com.ashis.ifloopswitchtrycatch

fun main() {
    val condition = 15 < 20
    val num = if (condition) 50 else 100

    val num2 = if (condition) {
        println("If block")
        75
    } else {
        println("else block")
        150
    }

    println("$num, $num2")

    println("The result of the expression is: ${if (!condition) {
        println("If block")
        75
    } else {
        println("else block")
        150
    }
    }")

    val x = if (condition) {
        println("If block")
    } else {
        println("else block")
    }

    println(x.javaClass) // Unit
}