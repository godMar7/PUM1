package lista3_godyn

fun evenPositiveSquare(list: List<Int>): List<Int> {
    return list
        .filterIndexed { index, _ -> index % 2 != 0 } // zostawiamy tylko elementy o nieparzystych indeksach
        .filter { it > 0 }                            // zostawiamy tylko liczby dodatnie
        .map { it * it }                              // podnosimy reszte liczb do kwadratu
}

fun main() {
    val input = listOf(1, 2, 3, 5, -6, -1, -1, 2, 3)
    println(evenPositiveSquare(input))
}