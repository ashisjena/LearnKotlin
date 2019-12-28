package com.ashis.ifloopswitchtrycatch

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun main() {
    println(getNumber("10"))
    println(getNumber("Hello")?: throw IllegalArgumentException())
}

fun getNumber(str: String): Int? {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        null
    } finally {
        println("finally block")
    }
}
