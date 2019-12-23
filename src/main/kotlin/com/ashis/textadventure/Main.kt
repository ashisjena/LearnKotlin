package com.ashis.textadventure

fun main(args: Array<String>) {
    val locations = readLocationInfo()

    var loc = 64

    while (true) {
        val location = locations[loc] ?: Location(0, "Sorry something went wrong. The game will terminate")

        println(location.description)

        if (location.locationId == 0) {
            break
        }

        print("Available exits are: ")
        locations.keys.forEach {
            print("$it, ")
        }
        println()

        val direction = readLine()?.toUpperCase() ?: "Z"
        val dest = location.getDestination(direction)

        dest?.let {
            loc = it
        } ?: println("You can't go in that direction")
    }
}