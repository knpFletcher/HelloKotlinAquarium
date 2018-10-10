package Books

fun main(args: Array<String>) {

    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("Shakespeare" to allBooks)

    println(library.any {it.value.contains("Hamlet")} )

    val moreBooks = mutableMapOf("A Christmas Carol" to "Charles Dickens")

    moreBooks.getOrPut("The Jungle Book") {"Kipling"}
    moreBooks.getOrPut("Hamlet") {"Shakespeare"}

    println(moreBooks)
}