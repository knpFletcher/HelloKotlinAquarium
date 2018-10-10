fun main(args: Array<String>) {
    val isUnit = println("This is an expression")
    println(isUnit)

    // Compacted conditionals
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)

    val message = "You are ${if (temperature > 50) "fried" else "safe"} fish" //using conditional as string template
    println(message)


    // Filters
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println(decorations.filter { true }) //will print all items

    println(decorations.filter { it[0] == 'p' }) //will print all items who's 1st character is p

    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")
    spices.filter { it.contains("curry") }.sortedBy { it.length } //sort curries by length

    spices.filter { it.startsWith('c') }.filter { it.endsWith('e') } // filter spices that start with c, end with e
    spices.filter { it.startsWith('c') && it.endsWith('e') } //a different way to do above

    spices.take(3).filter { it.startsWith('c') } //take the 1st 3 items and filter ones that start with c


    //Pairs
    val equipment = "fishnet" to "catching fish" //equipment and what it's good for
    println(equipment.first) //prints 'fishnet'
    println(equipment.second) //prints 'catching fish

    val equip = ("fishnet" to "catching fish") to ("of big size" to "and strong") // map pairs to pairs

    //destructuring pairs
    val fishnet = "fishnet" to "catching fish"
    val (tool, use) = fishnet
    println("The $tool is a tool for $use") //prints "The fishnet is a tool for catching fish

    fun giveMeATool(): Pair<String, String> {
        return ("fishnet" to "catching")
    }
    val (tools, uses) = giveMeATool() //destructure via a function


    //Collections
    val testList = listOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    println(testList.reversed()) //much shorter way to reverse, returns a new list

    //reverse elements in a list
    fun reverseList(list: List<Int>): List<Int> {
        val result = mutableListOf<Int>()
        for (i in list.size - 1 downTo 0) { //traverse list from end to beginning
            result.add(list.get(i))
        }
        return result
    }




}