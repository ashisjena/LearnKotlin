package com.ashis.textadventure

import java.io.File
import java.io.FileNotFoundException

fun readLocationInfo(locationsFileName: String, directionsFileName: String): Map<Int, Location> {
    val locations = mutableMapOf<Int, Location>()
    initializeLocations(locations, locationsFileName)
    initializeExitDirections(locations, directionsFileName)
    return locations
}

private fun initializeExitDirections(locations: MutableMap<Int, Location>, fileName: String) {
    File(asPath(fileName)).reader().forEachLine {
        val tokens = it.split(",")

        locations[tokens[0].toInt()]?.addExit(tokens[1], tokens[2].toInt())
    }
}

private fun initializeLocations(locations: MutableMap<Int, Location>, fileName: String) {
    File(asPath(fileName)).reader().forEachLine {
        val tokens = it.split("`")

        val location = Location(tokens[0].toInt(), tokens[1])
        locations[location.locationId] = location
    }
}

fun asPath(fileName: String): String {
    return object {}.javaClass.classLoader.getResource(fileName)?.path
        ?: throw FileNotFoundException("File: $fileName not Found")
}