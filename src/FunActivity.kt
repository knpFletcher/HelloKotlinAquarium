fun main (args: Array<String>) {
    whatShouldIDoToday("happy")
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) : String {
    return when {
        //when based on multiple conditions
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        mood == "sad" && weather == "rainy" && temperature == 0 -> "stay in bed"
        temperature > 35 -> "go swimming"
        else -> "Stay home and read."
    }
}