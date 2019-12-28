package com.ashis.anotherpackage

import com.ashis.enum.Department.IT
import com.ashis.objects.Singleton
import com.ashis.functions.labelMultiply as mult
import com.ashis.functions.upperFirstAndLast as ufal

fun main() {
    println(mult(5, 10))
    println(Singleton.getCopyrightLine())
    println(IT.getDeptInfo())
    println("some string".ufal())
}