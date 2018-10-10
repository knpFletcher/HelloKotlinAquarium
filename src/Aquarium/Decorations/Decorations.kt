package Aquarium.Decorations

fun main (args: Array<String>) {
    makeDecorations()

}

fun makeDecorations() {

    val d1 = Decorations("granite")
    println(d1) // print all properties instead of address of object / object pointer

    val d2 = Decorations("slate")
    println(d2)

    val d3 = Decorations("slate")
    println(d3)

    println(d1.equals(d2)) //f alse
    println(d3.equals(d2)) // true

    val d4 = d3.copy() // new object with same property values
    println(d3)
    println(d4)

    val d5 = Decorations2("crystal", "wood", "diver")
    println(d5)

    // decomposition
    val(rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)

}

data class Decorations(val rocks: String) {}

data class Decorations2(val rocks: String, val wood: String, val diver: String) {}