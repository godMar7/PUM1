package lista3_godyn

fun addToBoolean(): Map<Int, Boolean> {
    // robimy zakres od 1 do 20 i laczymy z wynikiem sprawdzenia czy jest parzysta
    return (1..20).associateWith { it % 2 == 0 }
}

fun main() {
    println(addToBoolean())
}