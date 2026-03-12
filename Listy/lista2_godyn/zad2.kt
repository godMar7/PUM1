package lista2_godyn

val <T> List<T>.tail: List<T>
    get() = this.drop(1)

val <T> List<T>.head: T
    get() = this.first()

fun main() {
    val liczby = listOf(1, 2, 3, 4, 5)
    println("lista: $liczby")
    println("pierwszy element: ${liczby.head}")
    println("reszta elementow: ${liczby.tail}")
    }