package com.ashis.lamdacollectiongenerics

fun main() {
    val setInts = setOf(10, 15, 3, 15, 23, 52)
    println(setInts.javaClass) // ImmutableSet

    val mutableSet = mutableSetOf(1, 3, 3, 4, 5, 32)
    println(setInts.javaClass)
    mutableSet.add(50)
    println(mutableSet)
    println(mutableSet.plus(100))
    println(mutableSet.minus(1))
    println(setInts.average())
    println(setInts.drop(3))
}