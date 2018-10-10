package Aquarium

fun main (args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = PlecostomusFish()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

//break AquariumFish into interfaces
interface FishActionAnother {
    fun eat()
}

interface FishColor {
    val color: String
}

//class handled by interface delegation

// make FishColor constructor parameter with default value, and defer calls to whatever fish color is passed in
class PlecostomusFish(fishColor: FishColor = GoldColor):
        FishAction by PrintingFishAction("a lot of algae"), FishColor by fishColor {

//implement both interfaces, get all functionality from interfaces
// defer all FishColor calls to obj GoldColor
//class PlecostomusFish: FishActionAnother, FishColor by GoldColor {

    //don't have to change code in body of Fish class
//    override fun eat() {
//        println("eat algae")
//    }


}

//declare class with one instance
object GoldColor: FishColor {
    override val color = "gold"
}

object RedColor: FishColor {
    override val color = "red"
}

//want a different instance for each food passed in
class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}