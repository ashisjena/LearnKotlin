package com.ashis.nullreferences

fun main() {
    val str: String? = null
    println("What happens when we do this : ${str?.toUpperCase()}")

    val str2: String? = "This is not null"
    str2?.toUpperCase().run(::println)

    str2?.let { println(it.toLowerCase().replace("a", "z.")) }
    val xyz = str2?.toLowerCase() ?: "I give up!" // Elvis operator is for default assignment during null

    val str3: String = str ?: "This is the default value of a nullable String"
    println(str3)

    val anyArr: Any = arrayOf(1, 2, 3, 4, "hello")
    val str4 = anyArr as? String // Safe cast operator
    println(str4)
    println(str4?.toUpperCase())

    val xx: String? = "This is a String"
    println(xx!!.toUpperCase()) // When we expect the value to be NotNull then we can use this operator to throw KotlinNullPointerException during null value
}