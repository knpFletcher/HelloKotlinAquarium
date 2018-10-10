package Aquarium.Generics

fun main(args: Array<String>) {
    genericExample()
}

// type hierarchy
open class WaterSupply(var needsProcessed: Boolean) //open so can subclass from it

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {

    fun addWater(cleaner: Cleaner<T>) {
        //kotlin will make sure generic usage is safe

        //check is standard library function to check state of class, acts as assertion
//        check(!waterSupply.needsProcessed) { "water supply needs processed" }

        if (waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }
}

//star projection, accept any version of T
inline fun <reified R : WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R
//return true if t is r

fun genericExample() {
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
//    aquarium4.addWater()

//    val aquarium2 = Aquarium("string") //can't pass String with WaterSupply type
//    println(aquarium2.waterSupply)

//    val aquarium3 = Aquarium(null) //impossible to pass null with Any
//    aquarium3.waterSupply
}

// out types
fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

fun genericExample2() {
    val aquarium = Aquarium(TapWater())
    val cleaner = TapWaterCleaner()
    aquarium.addWater(cleaner)
    addItemTo(aquarium) //has to be out type to do this
}

// in types
interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}


// generic functions
fun <T : WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    //t is type parameter to water supply, used to specify type of aquarium
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}

inline fun <reified T : WaterSupply> WaterSupply.isOfType() = this is T

fun genericExample3() {
    val aquarium = Aquarium(TapWater())
    aquarium.hasWaterSupplyOfType<TapWater>() //true
    aquarium.waterSupply.isOfType<LakeWater>() //false
}