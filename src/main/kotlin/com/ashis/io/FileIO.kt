package com.ashis.io

import java.io.*
import java.nio.charset.Charset

fun main() {
    val fileName = "testfile.txt"
    val path: String = getPath(fileName)
    println(path)
    // File(path).reader().readLines().forEach { println(it) } // Not suitable for huge files

    /*File(path).bufferedReader().use {
        var line: String? = it.readLine()
        while (line != null) {
            println(line)
            line = it.readLine()
        }
    }*/

    // File(path).bufferedReader().useLines { it.forEach { line -> println(line) } } // it is Kotlin "Sequence"
    File(path).bufferedReader().forEachLine(::println)

    val binaryFileName = "binaryfile.bin"
    val binaryFilePath = getPath(binaryFileName)

    DataInputStream(FileInputStream(binaryFilePath)).use {
        val data = ByteArray(1024)
        while (it.available() > 0) {
            it.read(data)
            print(String(data, Charset.defaultCharset()))
        }
    }
}

private fun getPath(fileName: String) = (object {}.javaClass.classLoader.getResource(fileName)?.path
        ?: throw FileNotFoundException("File: $fileName not Found"))
