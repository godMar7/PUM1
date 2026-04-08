package lista3_godyn

fun srt(list: List<String>): List<Pair<String, List<String>>> {
    return list
        .filter { it.length % 2 == 0 }  // zostawiamy slowa o parzystej dlugosci
        .groupBy { it.first().toString() }  // grupujemy po pierwszej literze
        .toList()   // zamieniamy Map<String, List<String>> na List<Pair<String, List<String>>>
        .sortedBy { it.first }  // sortujemy liste par rosnaco wzgledem pierwszej litery
}

fun main() {
    val input = listOf(
        "cherry",
        "blueberry",
        "citrus",
        "apple",
        "apricot",
        "banana",
        "coconut"
    )
    println(srt(input))
}