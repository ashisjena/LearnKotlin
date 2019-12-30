package com.ashis.lamdacollectiongenerics

fun main() {
    val strings = listOf("Spring", "Summer", "Fall", "Winter")
    println(strings.javaClass)

    val emptyList = emptyList<String>()
    println(emptyList.javaClass)
    if (!emptyList.isEmpty()) {
        println(emptyList[0])
    }

    val notNullList = listOfNotNull("hello", null, "goodbye")
    println(notNullList.javaClass)
    println(notNullList)

    val arrayList = arrayListOf(1, 2, 4)
    println(arrayList.javaClass)
    println(arrayList)
    arrayList[1] = 500

    val mutableList = mutableListOf(1, 2, 5)
    println(mutableList.javaClass)
    mutableList[2] = 100
    println(mutableList[2])
    println(mutableList.max())

    val array = arrayOf("Green", "Blue", "Black", "White", "Brown")
    // val colorList = listOf(*array) // Arrays.ArrayList
    val colorList = array.toList() // ArrayList
    println(colorList.javaClass)
    println(colorList.last())
    println(colorList.asReversed())
    println(colorList.getOrNull(5))
    println(colorList.getOrElse(2) { "Red" })
    println(colorList.zip(strings))
    println(colorList + strings)

    val mutableSeasons = strings.toMutableList()
    mutableSeasons.add("Winter")
    val noDupColors = mutableSeasons.distinct()
    val noDup = mutableSeasons.union(colorList)
    println(noDupColors)
    println(noDup)
}