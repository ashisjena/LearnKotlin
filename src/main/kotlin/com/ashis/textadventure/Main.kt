package com.ashis.textadventure

fun main() {
    val locations = readLocationInfo("locations_big.txt", "directions_big.txt")

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