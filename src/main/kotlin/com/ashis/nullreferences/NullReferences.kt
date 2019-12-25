package com.ashis.nullreferences

fun main() {
    val str: String? = null;
    println("What happens when we do this : ${str?.toUpperCase()}")

    val str2: String? = "This is not null"
    str2?.toUpperCase().run(::println)

    val str3: String = str ?: "This is the default value of a nullable String"

    val anyArr : Any = arrayOf(1, 2, 3, 4, "hello")
    val str4 = anyArr as? String // Safe cast operator
    println(str4)
    println(str4?.toUpperCase())
}