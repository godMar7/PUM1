package lista3_godyn

data class Point(val x: Int, val y: Int) {

    // operator + (dodawanie dwóch punktów)
    operator fun plus(other: Point) = Point(this.x + other.x, this.y + other.y)

    // operator + z liczbą całkowitą
    operator fun plus(value: Int) = Point(this.x + value, this.y + value)

    // operator - (odejmowanie punktów)
    operator fun minus(other: Point) = Point(this.x - other.x, this.y - other.y)

    // operator * (mnożenie punktów)
    operator fun times(other: Point) = Point(this.x * other.x, this.y * other.y)

    // operator ++ (inkrementacja)
    operator fun inc() = Point(this.x + 1, this.y + 1)

    // operator -- (dekrementacja)
    operator fun dec() = Point(this.x - 1, this.y - 1)

    // operator ! (negacja)
    operator fun not() = Point(-this.x, -this.y)
}

fun main() {
    //zmieniamy p1 na 'var' zebymóc użyć operatorów przypisania
    var p1 = Point(1, 1)
    val p2 = Point(2, 2)

    println("p1 + p2 ${p1 + p2}")

    p1 += 1
    println("p1 += 1 $p1")

    p1 = Point(1, 1)
    println("p1 - p2 ${p1 - p2}")
    println("p1 * p2 ${p1 * p2}")

    p1++
    println("p1++ $p1")

    p1 = Point(1, 1)
    p1--
    println("p1-- $p1")

    p1 = Point(1, 1)
    println("!p1 ${!p1}")
}