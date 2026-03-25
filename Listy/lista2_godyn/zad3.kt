package lista2_godyn

fun <A> isSorted(lst: List<A>, order: (A, A) -> Boolean): Boolean {
    return lst.zipWithNext().all { (a, b) -> order(a, b) }
    //zipWithNext robi pary elementow a .all sprawdza nasz warunek
}

fun main() {
    println(isSorted(listOf(1, 2, 3, 4)) { i, j -> i < j }) //true
    println(isSorted(listOf(1, 1, 1, 1)) { i, j -> i == j }) //true
    println(isSorted(listOf("ahyyhh", "bkjn", "cnn", "duu")) { i, j -> i.first() < j.first() }) //true
    println(isSorted(listOf(1, 3, 2, 4)) { i, j -> i < j }) //false
}