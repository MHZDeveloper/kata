/**
 * Created by mhz on 18/05/19.
 */


fun fizz(number:Int) : Boolean{
    return (number%3==0 || number.toString().contains("3"));
}

fun buzz(number:Int) : Boolean{
    return (number%5==0 || number.toString().contains("5"));
}

fun fizzbuzz(number:Int):String{
    if(fizz(number)&&buzz(number)){
        return "fizzbuzz"
    }
    else if(fizz(number)){
        return "fizz"
    }
    else if(buzz(number)){
        return  "buzz"
    }
    else{
        return number.toString()
    }
}


fun main(args: Array<String>) {
    for (i in 1..100)
        println(fizzbuzz(i))
}