package com.ashis.objects

fun main() {
    var thisIsMutable = 15
    wantsSomeInterface(object : SomeInterface {
        override fun mustImplement(num: Int): String {
            thisIsMutable++
            return "AnonymousObject: ${num + thisIsMutable}"
        }
    })

    println(thisIsMutable)
}

interface SomeInterface {
    fun mustImplement(num: Int): String
}

fun wantsSomeInterface(si: SomeInterface) {
    println("Printing from wantsSomeInterface: ${si.mustImplement(10)}")
}

