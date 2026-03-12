package lista2_godyn

data class UserInput(val name: String?, val email: String?, val age: String?)

data class UserProfile(
    var name: String = "",
    var email: String = "",
    var age: Int = 0,
    var isAdult: Boolean = false
)

fun buildProfile(input: UserInput?, logs: MutableList<String>): UserProfile? {
    // wykorzystanie run do szybszego wyjscia
    val validatedInput = input ?: run {
        logs.add("Input is null")
        return null
    }

    // let do sprawdzenia imienia
    val validName = validatedInput.name?.trim()?.let {
        if (it.length < 3) {
            logs.add("Name too short")
            return null
        }
        it
    } ?: run {
        logs.add("Name is null")
        return null
    }

    // sprawdzenie maila
    val validEmail = validatedInput.email?.trim()?.lowercase()?.let {
        if (!it.contains("@")) {
            logs.add("Invalid email")
            return null
        }
        it
    } ?: run {
        logs.add("Email is null")
        return null
    }

    // sprawdzenie wieku
    val validAge = validatedInput.age?.toIntOrNull() ?: run {
        logs.add(if (validatedInput.age == null) "Age is null" else "Age is not a number")
        return null
    }

    // apply do konfiguracji naszego obiektu, a also do logowania
    return UserProfile().apply {
        name = validName
        email = validEmail
        age = validAge
        isAdult = validAge >= 18
    }.also {
        logs.add("Profile created for ${it.email}")
    }
}

fun main() {
    val logs = mutableListOf<String>()
    val input = UserInput("Jan", "jan@wp.pl", "25")

    println("Tworzenie profilu")
    val profile = buildProfile(input, logs)

    if (profile != null) {
        println("Sukces: $profile")
    } else {
        println("Blad")
    }

    println("Logi systemowe: $logs")
}