package lista4_godyn

import java.time.LocalDate
import java.time.Month

enum class CostType(val costType: String) {
    REFUELING("Tankowanie"),
    SERVICE("Serwis"),
    PARKING("Parking"),
    INSURANCE("Ubezpieczenie"),
    TICKET("Mandat")
}

data class Cost(
    val type: CostType,
    val date: LocalDate,
    val amount: Int
)

fun groupedCostMap(costs: List<Cost>): Map<Month, List<Cost>> {
    // zwracamy metoda lancuchowania metod
    return costs
        //groupby tworzy mapy gdzie kluczem jest miesiac a wartoscia lista kosztow
        .groupBy { it.date.month }
        //tosortedmap() bierze mape i uklada rosaco po kluczach
        .toSortedMap()
}

fun main() {
    val sampleCosts = listOf(
        Cost(CostType.INSURANCE, LocalDate.of(2025, 1, 15), 2263),  // Styczeń
        Cost(CostType.PARKING, LocalDate.of(2025, 8, 13), 2350),    // Sierpień
        Cost(CostType.SERVICE, LocalDate.of(2025, 4, 20), 1933),    // Kwiecień
        Cost(CostType.INSURANCE, LocalDate.of(2025, 8, 24), 1524),  // Sierpień (drugi wydatek)
        Cost(CostType.PARKING, LocalDate.of(2025, 12, 15), 529)     // Grudzień
    )
    val result = groupedCostMap(sampleCosts)
    println("Pogrupowane i posortowane koszty:")
    println(result)
}