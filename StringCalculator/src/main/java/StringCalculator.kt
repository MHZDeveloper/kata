fun String.occurences(c: Char): Int {
    return this.filter { char -> char == c }.length
}

fun String.onlyContainsNumbersAndSpecialChars(vararg chars: Char): Boolean {
    return this.none { c -> !c.isDigit() && !chars.contains(c) }
}

fun add(number: String): String {
    when {
        number.isEmpty()
                ||
                number.length > 3
                ||
                number.occurences('.') > 1 -> return "0"
        !number.onlyContainsNumbersAndSpecialChars('.') -> return "error"
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
    when {
        number.isEmpty() -> return "0"
        !number.onlyContainsNumbersAndSpecialChars('.', '\n') -> return "error"
        !number.contains(".") && !number.contains("\n") -> return number
        (number[number.length - 1] == '\n' || number[number.length - 1] == '.') -> {
            println("Number expected but EOF found")
            return "error"
        }
    }
    var result = 0
    if (number[0].isDigit()) result = result + number[0].toInt() - '0'.toInt()
    for (i in 1 until number.length) {
        if ((number[i] == number[i - 1] && number[i] == '.')
                ||
                (number[i] == number[i - 1] && number[i] == '\n')
                ||
                (number[i - 1] == '.' && number[i] == '\n')
                ||
                (number[i - 1] == '\n' && number[i] == '.')) {

            println("should find a number at position $i")
            return "error"
        }
        if (number[i].isDigit())
            result = result + number[i].toInt() - '0'.toInt()
    }
    return result.toString()
}

fun addMultipleArgsWithDelimiter(number: String): String {
    when {
        number.length < 5 -> return "0"
        !number[0].equals('/') || !number[1].equals('/') || !number.contains('\n') -> return "error"
    }
    val delimiter = number[2]
    val operation = number.substring(4, number.length)
    when {
        !operation.onlyContainsNumbersAndSpecialChars(delimiter) -> return number
        operation[operation.length - 1] == delimiter -> {
            println("Number expected but EOF found")
            return "error"
        }
    }
    var result = 0
    if (operation[0].isDigit())
        result = result + operation[0].toInt() - '0'.toInt()
    for (i in 1 until operation.length) {
        if ((operation[i] == operation[i - 1] && operation[i] == delimiter)) {
            println("should find a number at position $i")
            return "error"
        }
        if (operation[i].isDigit())
            result = result + operation[i].toInt() - '0'.toInt()
    }
    return result.toString()
}