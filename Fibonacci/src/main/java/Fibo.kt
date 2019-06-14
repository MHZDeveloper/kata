import kotlin.coroutines.experimental.buildSequence
import kotlin.math.max


fun fiboIteration(n: Int): Int {
    val array = ArrayList<Int>()
    array.add(0)
    array.add(1)
    for (i in 2..n) {
        array.add(array.get(i - 1) + array.get(i - 2))
    }
    return array.get(n)
}

fun fiboRecursion(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    else return fiboRecursion(n - 1) + fiboRecursion(n - 2)
}

fun fiboIteration2(n: Int): Int {
    var x = 0
    var y = 1
    var z = -1
    var choose = 1
    for (i in 2..n) {
        when (choose) {
            1 -> z = x + y
            2 -> x = y + z
            3 -> y = x + z
        }
        if (choose == 3)
            choose = 1
        else
            choose++
    }
    return max(max(x, y), z)
}

fun fibonacci(): Sequence<Int> = buildSequence {
    var elements = Pair(0,1)
    while (true){
        yield(elements.first)
        elements = Pair(elements.second,elements.first+elements.second)
    }
}

fun main(args: Array<String>) {
    fibonacci().take(4).toList().toString() // "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() // "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}