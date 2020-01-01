package com.ashis.io

import java.io.File

fun main() {
    // File(".").walkTopDown().forEach(::println) // Directory First and files next
    File(".").walkBottomUp() // // Files First and then directory is printed
            .filter { it.name.endsWith(".kt") }
            .forEach(::println)
}