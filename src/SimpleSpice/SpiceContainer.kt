package SimpleSpice

data class SpiceContainer(var spice: AbstractSpice) {

    val label = spice.name

    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
            SpiceContainer(Curry("Red Curry", "medium")),
            SpiceContainer(Curry("Green Curry", "spicy")))

//    for(element in spiceCabinet) println (element.label)
}