package SimpleSpice

class Spice(val name: String, val spiciness: String = "mild") {

    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "atomic" -> 10
                else -> 0
            }
        }
    val spices1 = listOf(
            Spice("curry", "mild"),
            Spice("pepper", "medium"),
            Spice("cayenne", "spicy"),
            Spice("ginger", "mild"),
            Spice("red curry", "medium"),
            Spice("green curry", "mild"),
            Spice("hot pepper", "atomic")
    )

    val spice = Spice("cayanne", "spicy")

    val spiceList = spices1.filter { it.heat < 5 }
}

fun makeSalt() = Spice("salt")