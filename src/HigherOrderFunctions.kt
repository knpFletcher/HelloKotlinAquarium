data class Fish(var name: String) {}

fun main(args: Array<String>) {
    fishExamples()

    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    print(numbers.divisibleBy { it.rem(3) })
}

fun fishExamples() {
    val fish = Fish("splashy")

    //hof with extension lambda
//    with(fish.name) { this.capitalize() }

    //create our own 'with' function
    myWith(fish.name) { println(capitalize()) }
    //capitalize returns copy of passed in String, doesn't modify original

    // returns result of executing lambda
    println(fish.run { name })

    //returns object it is applied to
    println(fish.apply { })
    //common pattern for initializing objects
    val fish2 = Fish(name = "splashy").apply { name = "Sharky" }
    println(fish2.name)

    fish.let { it.name.capitalize() }
            .let { it + "fish" }
            .let { it.length }
            .let { it + 31 }

    //shortened to:
    fish.name.capitalize()
            .let { it + "fish" }.length + 31

    //without inline an object is created every call to myWith
    myWith(fish.name, object: Function1<String, Unit> {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })

    //with inline no object is created, capitalize is called directly
    fish.name.capitalize()

}

inline fun myWith(name: String, block: String.() -> Unit) {
    // convention defines function name as 'block'
    // specify class extending after colon, the receiver object
    // specify return type of argument

    // ^^ creates local extension function on String ^^

    name.block()
}

//Create an extension on List using a higher order function that returns all the numbers in the list that are divisible
// by 3. Start by creating an extension function on List that takes an lambda on Int and applies it to each item in the
// list. When the lambda returns zero, include the item in the output.

fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}

