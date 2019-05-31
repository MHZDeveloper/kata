fun String.getOccurances(c: Char): Int {
    var result = 0
    for (i in this) {
        if (i == c) result++
    }
    return result
}

fun add(number: String): String {
    when {
        number.isEmpty()
                ||
                number.length > 3
                ||
                !number.contains(".")
                ||
                number.getOccurances('.') > 1 -> return "0"

        number[0].isDigit() && number[2].isDigit() -> {
            val num1 = number[0].toInt() - '0'.toInt()
            val num2 = number[2].toInt() - '0'.toInt()
            val result = num1 + num2
            return number + "" + result.toString()
        }
    }
    return "null"
}

fun addMultipleArgs(vararg numbers: String) {
    numbers.forEach { number ->
        when {
            number.isEmpty()
                    ||
                    number.length > 3
                    ||
                    !number.contains(".")
                    ||
                    number.getOccurances('.') > 1 -> println(number + " -> 0")

            number[0].isDigit() && number[2].isDigit() -> {
                val num1 = number[0].toInt() - '0'.toInt()
                val num2 = number[2].toInt() - '0'.toInt()
                val sum = num1 + num2
                println(number + " -> " + sum.toString())
            }
        }
    }
}