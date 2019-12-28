package com.ashis.objects

import java.time.Year

fun main() {
    println(Singleton.getTagLine())
    println(Singleton.getCopyrightLine())
}

object Singleton {
    private val currentYear = Year.now().value

    internal fun getTagLine() = "Kotlin rocks!" // This internal fun can't be used from another module
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear Ashis. All rights reserved"
}