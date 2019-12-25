package com.ashis.array

fun main() {
    val arr = arrayOf("Ram", "Hari", "Shyam");

    /*for (ele in arr) {
        println(ele)
    }*/

    arr.forEach { println(it) }

    val intArr = intArrayOf(1, 2, 3, 5)
    /*Arrays.stream(intArr).forEach {
        println(it)
    }*/

    //  Arrays.stream(intArr).forEach(::println)
    intArr.forEach(::println)

    val typedArr: Array<Int> = intArr.toTypedArray()

    val primitiveArr = typedArr.toIntArray()

    //  val arr2 = Array<Int>(5) // Error, An typed array must be created with initialized value and can't be null.
    val intArr2 = IntArray(3) // this is possible, as default value is 0(Zero)

    val anyArr = arrayOf("Ram", 4, 3.5);
    println(anyArr is Array<Any>)
}