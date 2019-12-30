package com.ashis.lamdacollectiongenerics

import java.lang.Appendable
import java.lang.StringBuilder
import java.math.BigDecimal

fun main() {
    val bdList = mutableListOf(BigDecimal(-33.53), BigDecimal(3232.11))
    printCollection(bdList)

    bdList.printList()

    val floats: List<Float> = listOf(10.3f, 23.22f)
    convertToInt(floats)

    append(StringBuilder("String 1"), StringBuilder("String 2"))

    if (floats is List<Float>) { // Java instance of operator can't do floats instance of List<Float>, but here with Kotlin is operator can check this on compile time.
        println("This is a float list")
    }

    val listAny: MutableList<Any> = ArrayList()
    //  if(listAny is List<Float>) the below is an compile time error. As this involve runtime check.
    if (listAny is List<*>) { // This just like checking instance of List
        println("This is a list. Thank you star projection")
    }
    val dList = listAny as List<String> // This is unchecked type casting, can cause ClassCastException
}

fun <T> printCollection(collection: List<T>) {  // This can take nullable List
    collection.forEach(::println)
}

fun <T : Any> printCollec(collection: List<T>) {  // This restricts only non-nullable
    collection.forEach(::println)
}

fun <T> List<T>.printList() {
    this.forEach(::println)
}

fun <T : Number> convertToInt(collection: List<T>) {
    collection.forEach { println(it.toInt()) }
}

fun <T> append(item1: T, item2: T)
        where T : CharSequence, T : Appendable {
    println("Result is ${item1.append(item2)}")
}
