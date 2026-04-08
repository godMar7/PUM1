package lista3_godyn

fun suma(a: List<Int>): Int {
    // jesli liczba > 0 -> sumujemy
    return a.filter { it > 0 }.sum()
}

fun main() {
    val input = listOf(1, -4, 12, 0, -3, 29, -150)
    println(suma(input))
}
