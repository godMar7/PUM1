fun checkArmstrong(number: Int): Boolean {
    val text = number.toString()
    val power = text.length
    var sum = 0

    for (char in text) {
        val digit = char.digitToInt()
        var current = 1
        
        for (i in 1..power) {
            current *= digit
        }
        
        sum += current
    }

    return sum == number
}

fun main() {
    val number: Int = 153
    println(checkArmstrong(number))
}