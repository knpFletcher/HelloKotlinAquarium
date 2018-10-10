package Books

import Books.Constants.BASE_URL
import java.util.*

const val BORROW_LIMIT = 5

open class Book (val title: String, val author: String) {

    var pages = 1

    private var currentPage = 1

    open fun readPage() {
        currentPage++
    }

    // constants  //////////////////////////////////////////////
    fun canBorrow(hasBooks: Int): Boolean {
        return (hasBooks < BORROW_LIMIT)
    }

    fun printUrl() {
        println("$COMPANION_BASE_URL$title.html")
    }

    companion object {
        const val COMPANION_BASE_URL = "http://www.turtlecare.net/"
    }
    //endregion: constants

    // extension functions //////////////////////////////////
    val puppy = Puppy()
    val book = PagedBook("Oliver Twist", "Charles Dickens", 1837, 540)

    fun ifYouGiveAPupABook() {
        while (book.pages > 0) {
            puppy.playWithBook(book)
            println("${book.pages} left in ${book.title}")
        }
        println("Sad puppy, no more pages in ${book.title}")
        // endregion: extension functions
    }
}

class eBook(title: String, author: String, var format: String = "text"): Book(title,  author) {

    private var wordsRead = 0

    override fun readPage() {
        wordsRead += 250
    }
}

object Constants {
    const val BASE_URL = "http://www.turtlecare.net/"
}


class PagedBook(title: String, author: String, year: Int, pages: Int): Book(title, author)
//extension functions
fun Book.weight(): Double { return (pages * 1.5) }

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))
    }
}
