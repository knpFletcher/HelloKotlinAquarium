fun main(args: Array<String>) {
    var fortune: String
    for (i in 1..10) {
        //repeat (10)
        //wile(!fortune.contains("Take it easy")
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break
    }
}

fun getFortune(birthday: Int): String {

    val fortunes = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    return when (birthday) {
        in 1..7 -> fortunes[6]
        in 28..31 -> fortunes[4]
        else -> fortunes[birthday.rem(fortunes.size)]
    }
}

fun getBirthday() : Int {
    print("\nEnter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}