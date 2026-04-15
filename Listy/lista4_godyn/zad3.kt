package lista4_godyn

import java.time.LocalDate
import java.time.Month

// sealed class aby byly tylko 3 stany
sealed class MonthlyCostStatus {

    //data object bo brak kosztow nie musi przechowywac liczb
    data object NoCosts : MonthlyCostStatus()

    //data class bo te stany musza miec dane
    data class WithinLimit(val total: Int) : MonthlyCostStatus()
    data class OverLimit(val total: Int, val exceededBy: Int) : MonthlyCostStatus()
}

fun classifyMonthlyCosts(costs: List<Cost>, month: Month, limit: Int): MonthlyCostStatus {
    // filter aby odrzucic koszty innych miesiecy
    val monthlyCosts = costs.filter { it.date.month == month }

    //jesli lista jest pusta zwracamy brak kosztow
    if (monthlyCosts.isEmpty()) {
        return MonthlyCostStatus.NoCosts
    }

    //sumof przechodzi po liscie i sumuje amount
    val total = monthlyCosts.sumOf { it.amount }

    //sprawdzamy czy limit nie zostal przekroczony
    return if (total <= limit) {
        MonthlyCostStatus.WithinLimit(total)
    } else {
        MonthlyCostStatus.OverLimit(total, total - limit) // exceededBy to po prostu różnica
    }
}

fun main() {
    val sampleCosts = listOf(
        Cost(CostType.REFUELING, LocalDate.of(2025, 1, 10), 300),
        Cost(CostType.PARKING, LocalDate.of(2025, 1, 12), 50),
        Cost(CostType.SERVICE, LocalDate.of(2025, 2, 4), 1200)
    )

    println(classifyMonthlyCosts(sampleCosts, Month.JANUARY, 400))
    println(classifyMonthlyCosts(sampleCosts, Month.FEBRUARY, 1000))
    println(classifyMonthlyCosts(sampleCosts, Month.MARCH, 500))
}