package Aquarium

fun main(args: Array<String>) {
    buildAquarium()
    makeFish()
}

private fun buildAquarium() {
    val myAquarium = Aquarium() //new instance of Aquarium by calling constructor

    println("Length: ${myAquarium.length} ," +
            "Height: ${myAquarium.height} ," +
            "Width: ${myAquarium.width}")

    myAquarium.height = 80 //can var modify properties on val class
    println("Height: ${myAquarium.height} cm")

    println("Volume: ${myAquarium.volume} liters")

    val smallAquarium = Aquarium(20, 30, 15)
    println("Volume: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(9)

}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color} \n Plecostomus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}

//as long as fish object passed to method implements FishAction, can execute the method
fun feedFish(fish: FishAction) {
    //make some food then
    fish.eat()
}