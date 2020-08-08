
fun isLeapYear(year:Int):Boolean{
    return when{
        //year%4!=0 -> false
        year%4==0 && year%100!=0 -> true
        year%400==0 -> true
        //year%100==0 && year%400!=0 -> false
        else -> false
    }
}