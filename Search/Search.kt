
val tab : Array<Int> = arrayOf(3,2,1,4,6,5,8,9,7)
val sortedTab : Array<Int> = arrayOf(1,2,3,4,5,6,7,8,9)

//Linear search O[n]

fun linearSearch(value:Int):Int{
    tab.forEachIndexed { index, i -> if (tab[i]==value) return index }
    return -1
}

fun linearSearchRecursive(value:Int,pos:Int):Int{
    if (pos==tab.size)
        return -1
    else if (value==tab[pos])
        return pos
    else
        return linearSearchRecursive(value,pos+1)
}


//Binary search O[log n]

fun binarySearch(low:Int,high:Int,value:Int):Int{
    if (high>=low){
        val middle = (low+high)/2
        if (sortedTab[middle]==value)
            return middle
        else if (sortedTab[middle]<value)
            return binarySearch(middle+1,high,value)
        else
            return binarySearch(low,middle-1,value)
    }
    return -1
}