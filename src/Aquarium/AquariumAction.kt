package Aquarium

interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("swim")
    }

}

interface FishActionAgain{
    fun eat()
}

abstract class AquariumFishAgain: FishAction {
    abstract val color: String
    override fun eat() = println("yum")
}