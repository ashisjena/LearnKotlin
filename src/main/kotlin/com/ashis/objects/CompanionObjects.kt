package com.ashis.objects

fun main() {
    println(SomeClass.accessPrivateVar())
    println(SomeClass.getInstance("This is a String", false))
}

class SomeClass private constructor(val str: String) { // only can be instantiated through the factory method
    companion object {  // Similar to static fields or methods. Doesn't need to instantiate the SomeClass. i.e Grouping static members into companion object
        private const val privateVar = 6
        fun accessPrivateVar() = "I'm accessing private var $privateVar"
        fun getInstance(str: String, lowerCase: Boolean): SomeClass { // Acts as a factory method
            return if (lowerCase) {
                SomeClass(str.toLowerCase())
            } else {
                SomeClass(str.toUpperCase())
            }
        }
    }

    override fun toString(): String {
        return "SomeClass(str='$str')"
    }
}