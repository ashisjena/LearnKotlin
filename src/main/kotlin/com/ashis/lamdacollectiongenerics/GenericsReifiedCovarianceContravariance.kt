package com.ashis.lamdacollectiongenerics

import java.math.BigDecimal
import javax.print.attribute.standard.Destination

fun main() {
    val mixedList: List<Any> = listOf("Ram", true, BigDecimal(33.22), 100, "Hari", BigDecimal(20.1))
    val bigDecimalsOnly = getElementsOfType<String>(mixedList)
    println(bigDecimalsOnly)

    val shortList: MutableList<Short> = mutableListOf(10, 20, 30, 40) // Immutable list is covariant where subtype is preserved, but Mutable list is not covariant and subtype is not preserved
    // Here the subtype is ListOfShort in case of immutable list. And ListOfShort is subtype if ListOfNumber. Mutable list is invariant. Immutable list is covariant, as we can't add to this.
    convtToInt(shortList)

    val roseTender = object : FlowerCare<Rose> {
        override fun prune(flower: Rose) = println("I'm pruning a rose!")
    }
    val roseGarden = NGarden<Rose>(listOf(Rose(), Rose()), roseTender)
    roseGarden.tendFlower(0)

    val lillyTender = object : FlowerCare<Lilly> {
        override fun prune(flower: Lilly) = println("I'm pruning a lilly!")
    }
    val lillyGarden = NGarden<Lilly>(listOf(Lilly(), Lilly()), lillyTender)
    lillyGarden.tendFlower(0)

    val flowerTender = object : FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm tending a ${flower.name}!!!!")
    }
    val roseGarden2 = NGarden<Rose>(listOf(Rose(), Rose()), flowerTender)
    roseGarden2.tendFlower(0)

    val rose: MutableList<Rose> = mutableListOf(Rose(), Rose())
    val flowers: MutableList<Flower> = mutableListOf()
    copyFlowers(rose, flowers)
    println(flowers)
}

fun <T> copyFlowers(source: MutableList<out T>, destination: MutableList<in T>) {
    source.forEach { destination.add(it) }
}

inline fun <reified T> getElementsOfType(list: List<Any>): List<T> { // prevents type erasure in runtime. i.e captures the class obj of the passed type and we can use the class obj during runtime
    //  val newList: MutableList<T> = mutableListOf()  // reified only works with inline.
    return with(mutableListOf<T>()) {
        list.forEach {
            if (it is T) {
                this.add(it)
            }
        }
        this
    }
}

fun convtToInt(list: MutableList<out Number>) { // it's like <? extends Number>. Here we can't add to this list
    list.forEach { println("${it.toInt()}") }
    // list.add(15)
}


fun tendGarden(roseGarden: Garden<Rose>) {
    waterGarden(roseGarden)
}

fun waterGarden(garden: Garden<Flower>) {
}

open class Flower(val name: String)
class Rose : Flower("Rose")
class Lilly : Flower("Lilly")

class Garden<out T : Flower>(val something: T) { // We can't use var, as someone can assign a Lilly to a Rose Garden through setter. covariant
    val flowers: List<T> = listOf()

    fun pickFlower(i: Int): T = flowers[i]
    // fun plantFlower(flower: T){} We can't use something that is "out" in the function parameter as "in". It can only be used in return type

    fun checkFlower(flower: @UnsafeVariance T): Boolean { // We can override this behavior, but we shouldn't change the list. As someone can pass Lilly as well to a Rose List
        return true
    }
}

// https://stackoverflow.com/a/4343547
interface FlowerCare<in T> { // contravariant. i.e any subclass of T. <? super T>. Can't read. You can write only T and subclass of T. i.e function parameters are allowed but not return type
    fun prune(flower: T)
    // fun xyz() : T {} Because Object also can be added. Return type can't be fixed
}

class NGarden<T : Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = flowers[i]
    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}