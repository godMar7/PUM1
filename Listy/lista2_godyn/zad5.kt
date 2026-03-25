package lista2_godyn

fun check(n: Int, list: List<Int>): Int {
    for (i in n until list.size) {
        val target = list[i]
        val preamble = list.subList(i - n, i) // wyodrebniamy preambule

        val isValid = preamble.any { a ->
            val b = target - a
            a != b && preamble.contains(b)
        }

        if (!isValid) return target // zwracamy pierwszy niepasujacy element
    }
    // brak elementu niepasujacego: -1
    return -1
}

fun main() {
    val wynik1 = check(3, listOf(1, 2, 3, 5, 7, 12, 30))
    println(wynik1)

    val wynik2 = check(2, listOf(1, 2, 3, 4, 5, 6))
    println(wynik2)

    val wynik3 = check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576))
    println(wynik3)
}