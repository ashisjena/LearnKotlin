package com.ashis.array

fun main() {
    val shortArray1 = shortArrayOf(1, 2, 3, 4)
    val shortArray2: Array<Short> = arrayOf(1, 3, 5, 6)

    val arr = arrayOf("Ram", "Hari", "Shyam")

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

    val nullableInts = arrayOfNulls<Int>(5)
    nullableInts.forEach(::println)

    val intArray = Array<Int?>(40) { i -> (i + 1) * 5 }
}