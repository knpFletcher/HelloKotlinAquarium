import java.util.*

fun main(args: Array<String>) {
//no return type, doesn't return anything, default is Unit
    println("Hello ${args[0]}!")

    feedTheFish()

    swim()

    eagerFilterExample()
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day) //using default values
    shouldChangeWater(day, dirtyPercentage = 50) //call any parameters by name

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }

    dirtyProcessor()
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
    //java library for Random, number between 0 and 6, 7 is excluded
}

fun fishFood(day: String): String {
//    var food = "fasting" // can assign variable and work through when,
    // returning variable at the end, but the following way is more concise

    return when (day) {
    //when automatically breaks, don't need after each expression
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitos"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
//    return food
}

fun swim(speed: String = "fast") {
//default parameters, can call with parameters positionally or by name, or also without specifying
    println("Swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirtyPercentage: Int = getDirtySensorReading()): Boolean {
    //best practice to put arguments without defaults 1st
    //can use return value of function as default parameter value

    return when {
        isTooHot(temperature) -> true
        isTooDirty(dirtyPercentage) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30 // return type can be inferred from function, name gives hint to reader
//functions can be declared this way whenever they have a single expression in the body
fun isTooDirty(dirtyPercentage: Int) = dirtyPercentage > 30

fun isSunday(day: String) = day == "Sunday"

fun getDirtySensorReading() = 20

fun eagerFilterExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    val eager = decorations.filter { it[0] == 'p' }
    println(eager)

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)
}

var dirty = 20
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 } //lambda
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

//Higher Order Functions
fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)

    dirty = updateDirty(dirty, ::feedFish)
    //needs :: since it is a named function, not lambda (not trying to call, just pass reference

    dirty = updateDirty(dirty) { dirty -> dirty + 50 }
    //lambda as argument for operation, doesn't need to be inside parens. Last parameter call syntax
}

