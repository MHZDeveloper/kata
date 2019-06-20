fun power(a: Int, b: Int): Int {
    when {
        b == 0 -> return 1
        b == 1 -> return a
        else -> return a * power(a, b - 1)
    }
}

//more efficient

fun squareAndMultiply(a: Int, b: Int): Int {
    when {
        b == 0 -> return 1
        b == 1 -> return a
        b % 2 == 0 -> return squareAndMultiply(a * a, b / 2)
        else -> return a * power(a * a, (b - 1) / 2)
    }
}

fun main(args: Array<String>) {
    println(power(2, 3))
    println(squareAndMultiply(2, 3))
}