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
                number.getOccurances('.') > 1 -> return "0"

        !number.contains(".") -> return number

        number[0].isDigit() && number[2].isDigit() -> {
            val num1 = number[0].toInt() - '0'.toInt()
            val num2 = number[2].toInt() - '0'.toInt()
            val result = num1 + num2
            return result.toString()
        }
    }
    return number.replace(".", "")
}

fun addMultipleArgs(number: String): String {
    if (number.isEmpty()) {
        return "0"
    }
    if (!number.contains(".")) {
        return number
    }
    var result = 0
    for (i in 1 until number.length) {
        if (number[i] == number[i - 1] && number[i] == '.') return "error"
        if (number[i].isDigit())
            result = result + number[i].toInt() - '0'.toInt()
    }
    return result.toString()
}