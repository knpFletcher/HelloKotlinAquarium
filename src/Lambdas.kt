import java.util.*

/**
 * Created by knpfletcher on 6/6/18.
 */
fun main(args: Array<String>) {
    { println("Hello World") } ()
    //"Hello World"

    val swim = {println("swim \n")}
            //variable assigned to lambda
    swim()
    //"swim"

    var dirty = 20
    val waterFilter = { dirty: Int -> dirty / 2}
                    //lambda arguments -> lambda body
    val differentWaterFilter: (Int) -> Int = { dirty -> dirty / 2}
    //another way to use lambdas with function types
    //takes Int -> returns Int
    waterFilter(dirty) //call like so
//    10 returned


    val rollDice = { Random().nextInt(12) + 1} //lambda to roll 12-sided die

    val rollDiceSides = { sides: Int-> Random().nextInt(sides) +1}
    //extend lambda to take argument with sides of dice

    val rollDice0 = { sides: Int -> if (sides == 0) 0 else Random().nextInt(sides) +1}
    // return 0 if number of sides passed in is 0

    val rollDice2: (Int) -> Int = { sides -> if (sides == 0) 0 else Random().nextInt(sides) +1}
    // function type notation of above lambda

    fun gamePlay (diceRoll: Int) {
        println(diceRoll)
    }

    gamePlay(rollDice2(4))
}