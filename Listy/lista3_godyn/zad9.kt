package lista3_godyn

data class StudentScore(val name: String, val subject: String, val score: Int)

fun analyzeResults(students: List<StudentScore>): Triple<Map<String, List<StudentScore>>, List<StudentScore>, List<String>> {

    // mapa z listami studentow ktorzy zdali
    val passedBySubject = students
        .filter { it.score >= 50 }
        .groupBy { it.subject }

    // lista tych ktorzy nie zdali
    val failed = students
        .filter { it.score < 50 }

    // lista przedmitow gdzie wszyscy zdali
    val subjectsAllPassed = students
        .groupBy { it.subject } // grupujemy studentow po przedmiocie
        .filter { (_, studentsInSubject) ->
            studentsInSubject.all { it.score >= 50 } // zostawiamy tylko te grupy, gdzie kazdy ma >= 50
        }
        .keys      // pobieramy same nazwy przedmiotów (klucze z mapy) i zmieniamy na liste
        .toList()

    // zwracamy wszystkie trzy wyniki spakowane w obiekt Triple
    return Triple(passedBySubject, failed, subjectsAllPassed)
}

fun main() {
    val students = listOf(
        StudentScore("Alice", "Math", 78),
        StudentScore("Bob", "Math", 45),
        StudentScore("Charlie", "Physics", 92),
        StudentScore("Dave", "Physics", 55),
        StudentScore("Eve", "Physics", 40),
        StudentScore("Frank", "CS", 60),
        StudentScore("Grace", "CS", 80),
    )

    // rozpakowanie Triple na 3 osobne zmienne
    val (passedBySubject, failed, subjectsAllPassed) = analyzeResults(students)

    println("Zdani studenci według przedmiotów: $passedBySubject")
    println("Niezdani studenci: $failed")
    println("Przedmioty, w których wszyscy zdali: $subjectsAllPassed")
}