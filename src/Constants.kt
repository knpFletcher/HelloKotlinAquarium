import Constants.CONSTANT2
import sun.rmi.rmic.Constants

const val rocks = 3

val number = 5

const val num = 5

fun complexFunctionCall() {}

val result = complexFunctionCall()

//can't do this
//const val wontResult = complexFunctionCall()

const val CONSTANT = "top level constant"

object Constants {
    const val CONSTANT2 = "object constant"
}

val foo = CONSTANT2

class MyClass {
    companion object {
        const val CONSTANTS3 = "constant inside companion"
    }
}



