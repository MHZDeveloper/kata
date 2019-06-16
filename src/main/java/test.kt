import java.util.*

/**
 * Created by mhz on 26/05/19.
 */

fun String.getOccurances(c: Char): Int {
    var result = 0
    for (i in this) {
        if (i == c) result++
    }
    return result
}

fun ArrayList<Char>.getOccurances(c: Char): Int {
    var result = 0
    for (i in this) {
        if (i == c) result++
    }
    return result
}

fun evaluator(src: String, string: String): ArrayList<Int> {
    val lettersRightPosition = ArrayList<Char>()
    val lettersWrongPosition = ArrayList<Char>()

    for (i in src.indices) {
        for (j in string.indices) {
            if (src[i] == string[j]) {
                if (i == j) {
                    lettersRightPosition.add(src[i])
                } else {
                    if ((!lettersRightPosition.contains(src[i]) && src.getOccurances(src[i]) == 1)
                            ||
                            (lettersRightPosition.contains(src[i]) && src.getOccurances(src[i]) > 1))
                        lettersWrongPosition.add(src[i])
                }
            }
        }
    }
    for (i in src.indices) {
        if (lettersRightPosition.contains(src[i]) && lettersWrongPosition.contains(src[i])) {
            val occ = src.getOccurances(src[i])
            val diff = Math.abs(occ - lettersRightPosition.getOccurances(src[i]) - lettersWrongPosition.getOccurances(src[i]))
            if (diff > 0) {
                for (j in 1..diff)
                    lettersWrongPosition.remove(src[i])
            }
        }
    }
    println("letters right position : " + lettersRightPosition)
    println("letters wrong position : " + lettersWrongPosition)

    return arrayListOf(lettersRightPosition.size, lettersWrongPosition.size)
}


class Person{
    val name:String = "MHZ"

    var age:Int=18
}


//fun main(args: Array<String>) {
//    val sum  = {x:Int,y:Int  -> x+y}
//    val even = { x:Int -> x%2==0}
//    println(sum(5,3))
//    println(even(5))
//    val person = Person()
//    person.age=10
//    println(Random(5).nextInt())
//}

        //Task1
//fun isValidIdentifier(s: String): Boolean {
//    if(s.isEmpty()) return false
//    for ((index,char) in s.withIndex()){
//        when{
//            index==0 && !char.isLetter() && char!='_' -> return false
//            !char.isLetter() && char!='_' && !char.isDigit() -> return false
//        }
//    }
//    return true
//}
//
//fun main(args: Array<String>) {
//    println(isValidIdentifier("name"))   // true
//    println(isValidIdentifier("_name"))  // true
//    println(isValidIdentifier("_12"))    // true
//    println(isValidIdentifier(""))       // false
//    println(isValidIdentifier("012"))    // false
//    println(isValidIdentifier("no$"))    // false
//}


        //Task2


//fun List<Int>.sum() :Int{
//    var result = 0
//    for (element in this)
//        result=result+element
//    return result
//}
//
//fun main(args: Array<String>) {
//    println(listOf(1, 2, 3).sum())    // 6
//}

    //Task 3

//fun String?.isEmptyOrNull() : Boolean{
//    var result = false
//    if (this==null || this.isEmpty())
//        result=true
//    return result
//}
//
//infix fun Boolean.eq(variable:Boolean) : Boolean{
//    return this==variable
//}
//
//fun main(args: Array<String>) {
//    val s1: String? = null
//    val s2: String? = ""
//    println(s1.isEmptyOrNull() eq true)
//    println(s2.isEmptyOrNull() eq true)
//
//    val s3 = "   "
//    println(s3.isEmptyOrNull() eq false)
//}

        //Task 4

//fun main(args: Array<String>) {
//    val s = "hello"
//    println(s as? Int)    // null
//    println(s as Int?)    // exception
//}

        //Task 5

//fun List<Int>.allNonZero() =  all { it!=0 }
//fun List<Int>.allNonZero1() =  none { it==0 }
//fun List<Int>.allNonZero2() =  !any { it==0 }
//
//fun List<Int>.containsZero() =  any { it==0 }
//fun List<Int>.containsZero1() =  !all { it!=0 }
//fun List<Int>.containsZero2() =  !none { it==0 }
//
//infix fun Boolean.eq(variable:Boolean) : Boolean{
//    println(this==variable)
//    return this==variable
//}
//
//fun main(args: Array<String>) {
//    val list1 = listOf(1, 2, 3)
//    //list1.allNonZero() eq true
//    //list1.allNonZero1() eq true
//    //list1.allNonZero2() eq true
//
//    //list1.containsZero() eq false
//    list1.containsZero1() eq false
//    list1.containsZero2() eq false
//
//    val list2 = listOf(0, 1, 2)
//    //list2.allNonZero() eq false
//    //list2.allNonZero1() eq false
//    //list2.allNonZero2() eq false
//
//    //list2.containsZero() eq true
//    list2.containsZero1() eq true
//    list2.containsZero2() eq true
//}

        //Task 6

//var number =0
//val foo: Int = 1
//    get() {
//        number+=1
//        return field*number
//    }
//fun main(args: Array<String>) {
//    // The values should be different:
//    println(foo)
//    println(foo)
//    println(foo)
//}

    //Task 7

//infix fun Boolean.eq(variable:Boolean) : Boolean{
//    println(this==variable)
//    return this==variable
//}
//data class Value(val s: String)
//
//fun equals1(v1: Value?, v2: Value?): Boolean {
//    return v1 == v2
//}
//
//fun equals2(v1: Value?, v2: Value?): Boolean {
//    if (v1!=null && v2!=null)
//        return v1.equals(v2)
//    else
//        return v1===v2
//}
//
//fun main(args: Array<String>) {
//    equals1(Value("abc"), Value("abc")) eq true
//    equals1(Value("abc"), null) eq false
//    equals1(null, Value("abc")) eq false
//    equals1(null, null) eq true
//
//    equals2(Value("abc"), Value("abc")) eq true
//    equals2(Value("abc"), null) eq false
//    equals2(null, Value("abc")) eq false
//    equals2(null, null) eq true
//}

        //Task8

//infix fun String.eq(variable:String) : Boolean{
//    println(this.equals(variable))
//    return this.equals(variable)
//}
//
//fun filterNonZero(list: List<Int>) = list.filter { it != 0 }
//
//fun filterNonZeroGenerated(list: List<Int>): List<Int> {
//    val destination = ArrayList<Int>()
//    for (element in list){
//        if(element!=0)
//            destination.add(element)
//    }
//    return destination
//}
//
//fun main(args: Array<String>) {
//    val list = listOf(1, 2, 3)
//
//    filterNonZero(list).toString() eq "[1, 2, 3]"
//    filterNonZeroGenerated(list).toString() eq "[1, 2, 3]"
//}
//
//inline fun <T> Iterable<T>.filter(predicate: (T) -> Boolean): List<T> {
//    val destination = ArrayList<T>()
//    for (element in this) {
//        if (predicate(element)) {
//            destination.add(element)
//        }
//    }
//    return destination
//}

//fun main(args: Array<String>) {
//    val input = generateSequence { readLine().takeIf { it!="exit" } }
//    println(input.toList())
//}

        //Task9
//infix fun String.eq(variable:String) : Boolean{
//    println(this.equals(variable))
//    return this.equals(variable)
//}
//
//fun fibonacci(): Sequence<Int> = buildSequence {
//    var element = Pair(0,1)
//    while (true){
//        yield(element.first)
//        element = Pair(element.second,element.first+element.second)
//    }
//}
//
//fun main(args: Array<String>) {
//    fibonacci().take(4).toList().toString() eq
//            "[0, 1, 1, 2]"
//
//    fibonacci().take(10).toList().toString() eq
//            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
//}

