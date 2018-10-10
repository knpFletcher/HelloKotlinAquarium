fun main (args: Array<String>) {
    println(whatShouldIDoTodayAgain(readLine()!!))
}

fun whatShouldIDoTodayAgain(mood: String, weather: String = "sunny", temperature: Int = 24) : String {
    print("\nHow are you feeling today? ")

    return when {
        happyAndSunny(mood, weather) -> "go for a walk"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        letsGoSwimming(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun happyAndSunny(mood: String, weather: String) = mood == "happy" && weather == "Sunny"
fun isSadRainyCold(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun letsGoSwimming(temperature: Int) = temperature > 35