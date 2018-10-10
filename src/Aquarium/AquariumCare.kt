package Aquarium

fun main (args: Array<String>) {

    val symptoms = mutableListOf("white spots", "red spots", "not eating", "bloated", "belly up")
    symptoms.add("white fungus")
    symptoms.remove("white fungus")

    symptoms.contains("red") //false
    symptoms.contains("red spots") // true

    println(symptoms.subList(4, symptoms.size)) //belly up
    //creates list from 1st argument index, to and excluding 2nd index

    listOf(1, 5, 3).sum() //9

    listOf("a", "b", "cc").sumBy { it.length } //4
    //takes lambda to specify what property of elements to summarize
    // it is default name for lambda arguments, here refers to each element of list as it's traversed


    //mapping
    val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")

    //retrieve disease value based on symptom key
    println(cures.get("white spots"))
    println(cures["white spots"]) //shorter way to do above

    //if key is not found in list
    println(cures.getOrDefault("bloating", "sorry, I don't know"))

    //instead of returning value, executes code between {}
    cures.getOrElse("bloating") {"No cure for this"}

    val inventory = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fish net")

}