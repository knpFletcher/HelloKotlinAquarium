package Buildings

fun main (args: Array<String>) {
    Building(Wood()).build()
}

open class BaseBuildingMaterial() {
    open val numberNeeded = 1
}

class Wood: BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick: BaseBuildingMaterial() {
    override val numberNeeded = 8
}

// take any building material as argument, but only building materials
class Building<out T: BaseBuildingMaterial>(val buildingMaterials: T) {

    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = buildingMaterials.numberNeeded * baseMaterialsNeeded

    fun build() {
        println("$actualMaterialsNeeded ${buildingMaterials::class.simpleName} required")
    }

}

fun<T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("Small building")
    else println("Large building")
}

//isSmallBuilding(Building(Brick()))
