package com.ashis.ifloopswitchtrycatch

fun main() {
    val length = 5
    val range = 1..length
    val charRange = 'a'..'z'
    val stringRange = "ABC".."XYZ"
    range.forEach(::print)
    println()
    for (i in range) {
        print(i)
    }
    println()
    charRange.forEach(::print)
    println()
//    stringRange.forEach(::print) // forEach doesn't work for string range

    println(3 in range)
    println('q' in charRange)
    println("CCC" in stringRange)
    println("CCCCCCC" in stringRange)
    println("ZZZZZZ" in stringRange)

    val backwardRange = 5.downTo(1)
    println(5 in backwardRange)
    val r = 5..1  // It doesn't work as it's a empty range. As start should be smaller than end
    println(5 in r)

    val stepRange = 3..15
    val stepThree = stepRange.step(3)
    stepThree.forEach(::print)
    println()
    val reversedRange = stepThree.reversed()
    reversedRange.forEach(::print)
    println()

    for (i in 0..20 step 4) {
        print(i)
    }
    println()

    for (i in 20 downTo 10 step 2) {
        print(i)
    }
    println()

    for (i in 0 until 5) { // excluding the last index
        print(i)
    }
    println()

    val str = "Hello"
    for (c in str) {
        print(c)
    }
    println()
    println('e' in str)
    println('e' !in str)

    val seasons = arrayOf("spring", "summer", "winter", "fall", "rainy")
    for (season in seasons) {
        println(season)
    }
    for (index in seasons.indices) {
        println("${seasons[index]} is season number $index")
    }
    seasons.forEach { println(it) }
    seasons.forEachIndexed { index, value -> println("$value is season number $index") }

    val notASeason = "blahblah" !in seasons
    println(notASeason)
    val notInRange = 32 !in 1..10
    println(notInRange)

    for (i in 1..3) {  // names or labels of for loop
        println("i = $i")
        jLoop@ for (j in 4..6) {
            println("j = $j")
            for (k in 7..10) {
                println("k = $k")
                if (k == 8)
                    break@jLoop
            }
        }
    }

    fibonacci(10)
}

fun fibonacci(num: Int) {
    var secondToLast = 0
    var last = 1

    println(secondToLast)
    println(last)
    for(i in 1..num) {
        val total = secondToLast + last
        println(total)
        secondToLast = last
        last = total
    }
}