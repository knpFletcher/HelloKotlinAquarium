package Aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {
    val size: Int

    init {
        println("first init block")
    }

    //secondary constructor
    constructor(): this(true, 9) {
        //must contain call to primary constructor with 'this'
        println("running secondary constructor")
    }

    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded *2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded: final size ${this.size}")
    }

    init {
        println("last init block")
    }

}

fun makeDefaultFish() = Fish(true, 50) //helper function

fun fishExample() {
    val fish = Fish(true, 20)
    println("Is the fish friendly? ${fish.friendly}. It needs ${fish.size} volume")
}

