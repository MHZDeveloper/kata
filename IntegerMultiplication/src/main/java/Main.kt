import java.util.*

fun Int.toList(): ArrayList<Int> {
    val result = ArrayList<Int>()
    val toString = this.toString()
    for (i in 0 until toString.length) {
        result.add(toString[i].toInt() - 48)
    }
    return result
}


fun naiveMultiplication(x: Int, y: Int): Int {

    return 0;
}


fun karatsubaMultiplication(x: Long, y: Long): Long {
    if (x < 10 || y < 10) {
        return x * y
    }
    val m = Math.round(java.lang.Long.toString(x).length.toFloat()).toDouble()
    val m2 = m / 2
    val a = (x / Math.pow(10.0, Math.round(m2).toDouble())).toLong()
    val b = (x % Math.pow(10.0, Math.round(m2).toDouble())).toLong()
    val c = (y / Math.pow(10.0, Math.round(m2).toDouble())).toLong()
    val d = (y % Math.pow(10.0, Math.round(m2).toDouble())).toLong()
    val z0 = karatsubaMultiplication(a, c)
    val z1 = karatsubaMultiplication(b, d)
    val z2 = karatsubaMultiplication(a + b, c + d)

    return (z0 * Math.pow(10.0, Math.round(m).toDouble()) + (z2 - z1 - z0) * Math.pow(10.0, Math.round(m2).toDouble()) + z1.toDouble()).toLong()
}