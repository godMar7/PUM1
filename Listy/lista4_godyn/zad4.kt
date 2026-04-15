package lista4_godyn

import java.time.LocalDate

interface CostFormatter {
    fun format(cost: Cost): String
}

//tworzymy singleton ktory implementuje interfejs
object PlCostFormatter : CostFormatter {
    override fun format(cost: Cost): String {
        //padstart wymaga 2 liczb i uzupelnia 0 z przodu jak nie ma
        val day = cost.date.dayOfMonth.toString().padStart(2, '0')
        return "$day ${cost.type.name} ${cost.amount} zł"
    }
}

fun formatCosts(costs: List<Cost>, formatter: CostFormatter): String {
    return costs
        // sortujemy po dacie
        .sortedBy { it.date }

        //przeksztalcamy wszystkie cost na stringi
        .map { cost -> formatter.format(cost) }

        //laczymy cala liste
        .joinToString(separator = "\n")
}

fun main() {
    val sampleCosts = listOf(
        Cost(CostType.PARKING, LocalDate.of(2025, 1, 15), 30),
        Cost(CostType.SERVICE, LocalDate.of(2025, 1, 5), 900)
    )
    val result = formatCosts(sampleCosts, PlCostFormatter)
    println(result)
}