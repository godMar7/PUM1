fun printPascal(height: Int): String {
    return buildString {
        for (i in 0 until height) {
            append(" ".repeat(height - i - 1))
            
            var number = 1
            for (j in 0..i) {
                append("$number ")
                number = number * (i - j) / (j + 1)
            }
            
            if (i < height - 1) {
                append("\n")
            }
        }
    }
}

fun main() {
    val height: Int = 5
    println(printPascal(height))
}