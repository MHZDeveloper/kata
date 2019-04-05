fun compute1(number: Int): String {

    val stringNumber = number.toString()

    var divideResult = ""


    if (number != 0) {
        if (number % 3 == 0) divideResult += "Foo"
        if (number % 5 == 0) divideResult += "Bar"
        if (number % 7 == 0) divideResult += "Qix"
    }

    var digitResult = ""

    for (i in 0..stringNumber.length - 1) {
        when {
            stringNumber[i] == '3' -> digitResult += "Foo"
            stringNumber[i] == '5' -> digitResult += "Bar"
            stringNumber[i] == '7' -> digitResult += "Qix"
        }
    }

    if ((divideResult + digitResult).isEmpty()) {
        return stringNumber
    } else {
        return divideResult + digitResult
    }
}


fun compute2(number: Int): String {

    var stringNumber = number.toString()

    var divideResult = ""


    if (number != 0) {
        if (number % 3 == 0) divideResult += "Foo"
        if (number % 5 == 0) divideResult += "Bar"
        if (number % 7 == 0) divideResult += "Qix"
    }

    var digitResult = ""

    for (i in 0..stringNumber.length - 1) {
        when {
            stringNumber[i] == '3' -> digitResult += "Foo"
            stringNumber[i] == '5' -> digitResult += "Bar"
            stringNumber[i] == '7' -> digitResult += "Qix"
            stringNumber[i] == '0' -> digitResult += "*"
        }
    }


    if ((divideResult + digitResult).replace("[*]".toRegex(), "").isEmpty()) {
        stringNumber = stringNumber.replace("[0]".toRegex(), "*")
        return stringNumber
    } else {
        return divideResult + digitResult
    }
}