fun isPrime1(number: Int): Boolean {
    var i = 2
    while (i <= number - 1) {
        if (number % i == 0)
            return false
        i += 1
    }
    return true
}

fun isPrime2(number: Int): Boolean {
    when {
        number <= 1 -> return false
        number <= 3 -> return true
        number % 2 == 0 || number % 3 == 0 -> return false
    }
    var i = 5
    while (i*i<=number){
        if (number%i==0 || number%(i+2)==0)
            return false
        i+=6
    }
    return true
}


fun main(args: Array<String>) {
    println(isPrime1(17)) //true
    println(isPrime2(17)) //true
    println(isPrime2(199)) //true
    println(isPrime2(150)) //false
}