fun isPalindrome(word: String): Boolean {
    return word == word.reversed()
}

fun main() {
    val word = "kamilslimak"
    println(isPalindrome(word))
}