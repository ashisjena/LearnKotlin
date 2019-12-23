package com.ashis.textadventure

data class Location(val locationId: Int, val description: String) {
    private val exits = mutableMapOf<String, Int>()

    init {
        exits["Q"] = 0
    }

    fun addExit(direction: String, destinationId: Int) {
        exits[direction] = destinationId
    }

    fun getDestination(direction: String): Int? {
        return exits[direction]
    }
}