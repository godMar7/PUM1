package lista2_godyn

fun safeParseAndClassify(input: String?): String {
    val number = input?.toIntOrNull() ?: return "BRAK_DANYCH"
    return if (number % 2 == 0) "PARZYSTA" else "NIEPARZYSTA"
}

fun main() {
    println(safeParseAndClassify(null)) //BRAK_DANYCH
    println(safeParseAndClassify("")) //BRAK_DANYCH
    println(safeParseAndClassify("tekst")) //BRAK_DANYCH
    println(safeParseAndClassify("4")) //PARZYSTA
    println(safeParseAndClassify("7")) //NIEPARZYSTA
}