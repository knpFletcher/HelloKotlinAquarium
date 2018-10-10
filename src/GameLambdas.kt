
enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game {

    var path = mutableListOf(Directions.START)

    val north = {path.add(Directions.NORTH)}
    val south = {path.add(Directions.SOUTH)}
    val east = {path.add(Directions.EAST)}
    val west = {path.add(Directions.WEST)}

    val end = { path.add(Directions.END);
        println("Game Over: $path");
        path.clear();
        false }

    //3/ function that takes nullable String as argument, returns nothing
    fun makeMove(moveDirection: String?){
        //4/ test if argument is any of 4 directions and invoke move with corresponding lambda
        if (moveDirection.equals("n")) move(north)
        else if (moveDirection.equals("s")) move(south)
        else if (moveDirection.equals("e")) move(east)
        else if (moveDirection.equals("w")) move(west)
        else move(end)
    }

}

// 1/ lambda argument, with no arguments, returns Unit
fun move(where:() -> Boolean) {
    //2/ invoke passed in lambda
    where.invoke()
}

fun main (args: Array<String>) {

    val game = Game()
    println(game.path)
    game.north()
    game.south()
    game.east()
    game.west()
    game.end()
    println(game.path)

    //5 while loop that is always true
    while(true) {
        //6 print instructions to player
        print("Enter a direction: n/s/e/w: ")
        // move corresponding to input
        game.makeMove(readLine())
    }
}