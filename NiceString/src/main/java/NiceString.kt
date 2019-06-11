fun String.isNice(): Boolean {
    val vowels = arrayListOf<Char>('a','e','i','o','u')
    var satisfiedConditions=0

    if (setOf("ba","bu","be").none { this.contains(it) })
        satisfiedConditions+=1
    

    if(this.filter { char -> char in vowels }.count()>=3)
        satisfiedConditions+=1

    for (i in 0 until this.length-1){
        if(this[i]==this[i+1]){
            satisfiedConditions+=1
            break
        }
    }

    if (satisfiedConditions>=2) return true
    else return false

}