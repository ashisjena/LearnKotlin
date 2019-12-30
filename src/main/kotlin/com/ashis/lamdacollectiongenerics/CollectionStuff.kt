package com.ashis.lamdacollectiongenerics

fun main() {
    val setInts = setOf(10, 15, 20, 25, 30, 35, -40, 45, 50, 55, 60)

    println(setInts.filter { it % 2 != 0 })
    val nums = setInts.map { it + 10 }
    println(nums)
    println(nums.javaClass)

    println(setInts.filter { it % 2 == 0 }.map { it + 10 })

    println(setInts.all { it > 20 })
    println(setInts.any { it > 20 })
    println(setInts.count { it > 20 })
    println(setInts.find { it < 15 })
    println(setInts.groupBy { it % 2 })
    println(setInts.toSortedSet())
    println(setInts.toSortedSet().javaClass)
    println(setInts.sortedBy { it })
    println(setInts.sortedWith(Comparator { num1, num2 -> num2.compareTo(num1) }))

    println(setInts.asSequence().filter { it % 2 == 0 }.map { it + 10 }.toList()) // sequence is similar to Stream. These doesn't produce any intermediate collection.
    // Sequence or stream gets evaluated only when there is a terminal operation
    println(setInts.asSequence().filter { println("Filtering $it"); it % 2 == 0 }.map { println("Mapping $it"); it + 1 }.find { it >= 10 })
    println(setInts.filter { println("Filtering $it"); it % 2 == 0 }.map { println("Mapping $it"); it + 1 }.find { it >= 10 })
}