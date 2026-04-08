package lista3_godyn

fun countElements(list: List<List<String>>): Map<String, Int> {
    return list
        .flatten()               // splasza liste list do jednej listy
        .groupingBy { it }       // grupuje elementy wedlug wartosci
        .eachCount()             // liczy ile elementow jest w kazdej grupie
}

fun main() {
    val input = listOf(
        listOf("a", "b", "c"),
        listOf("c", "d", "f"),
        listOf("d", "f", "g")
    )
    println(countElements(input))
}