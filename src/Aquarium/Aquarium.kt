package Aquarium

import kotlin.math.PI

//inherits from top level class
open class Aquarium(var length: Int = 100, var height: Int = 20, var width: Int = 40) {
//creates member values for you and assigns default values

    open var volume: Int
        get() = width + height + length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        //create another constructor
        val water = numberOfFish * 2000 //cm3
        val tank = water + water * 0.1
        height = (tank / (length * width)).toInt()

    }
}

//inherits from Aquarium
class TowerTank() : Aquarium() {
    override var water = volume * 0.8

    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }
}