fun isPerfect(number: Int): String {
    var sum = 0
    
    for (i in 1 until number) {
        if (number % i == 0) {
            sum += i
        }
    }
    
    return when {
        sum == number -> "doskonała"
        sum > number -> "obfita"
        else -> "niedomiarowa"
    }
}

fun main() {
    val number1 = 28
    println(isPerfect(number1))
    
    val number2 = 12
    println(isPerfect(number2))
    
    val number3 = 8
    println(isPerfect(number3))
}