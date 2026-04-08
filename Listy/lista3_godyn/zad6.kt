package lista3_godyn

fun perm(list: List<Int>): List<List<Int>> {
    // warunek kończacy rekurencje
    if (list.isEmpty()) return listOf(emptyList())

    return list.indices.flatMap { i ->
        val element = list[i]   //nowa lista bez aktualnego elemetnu
        val remaining = list.filterIndexed { index, _ -> index != i }

        //wywolujemy funkcje rekurencyjnie i dolaczamy element na poczatek kazdej sub-permutacji
        perm(remaining).map { subPermutation -> listOf(element) + subPermutation }
    }
}

fun main() {
    println(perm(listOf(1, 2, 3)))
}