fun main(args: String) {
    when (args.toInt()) {
        in 0..12 -> println("Good morning, Kotlin")
        in 12..23 -> println("Good night, Kotlin")
        else -> println("Time is a flat circle")
    }
    //other option:
    if (args[0].toInt() <12) println("Good morning, Kotlin")
    else println("Good night, Kotlin")

    // another way to do:
    println(if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin")
}
