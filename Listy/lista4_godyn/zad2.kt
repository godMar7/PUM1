package lista4_godyn

import java.time.LocalDate
import java.time.Month

fun printCosts(costs: List<Cost>) { costs
        //sortedby sortuje nam koszty po dacie
        .sortedBy { it.date }

        //robimy grupy po miesiacach
        .groupBy { it.date.month }

        //iterujemy po mapie gdzie miesiac to klucz
        .forEach { (month, costsInMonth) ->
            println(month)
            // wypisujemy dni z danej grupy
            costsInMonth.forEach { cost ->
                //padStart robi ze tekst ma miec 2 znaki i jak nie ma to daje 0 z przodu
                val day = cost.date.dayOfMonth.toString().padStart(2, '0')

                println("$day ${cost.type.name} ${cost.amount} zł")
            }
        }
}

fun main() {
    val sampleCosts = listOf(
        Cost(CostType.SERVICE, LocalDate.of(2025, 4, 4), 1933),
        Cost(CostType.TICKET, LocalDate.of(2025, 12, 24), 2500),
        Cost(CostType.INSURANCE, LocalDate.of(2025, 1, 1), 2012),
        Cost(CostType.PARKING, LocalDate.of(2025, 1, 15), 300)
    )
    printCosts(sampleCosts)
}