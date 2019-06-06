data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun String.getOccurances(c: Char): Int {
    var result = 0
    for (i in this) {
        if (i == c) result++
    }
    return result
}

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPositions = mutableMapOf<Int, Char>()
    val wrongPositions = mutableMapOf<Int, Char>()
    val wrongGuesses = mutableMapOf<Int, Char>()

    for (index in 0 until secret.length) {
        if (secret[index] == guess[index])
            rightPositions[index] = secret[index]
    }

    for ((secretIndex, secretChar) in secret.withIndex()) {
        for ((guessIndex, guessChar) in guess.withIndex()) {
            if (secretChar == guessChar) {
                if (rightPositions.containsKey(secretIndex))
                    continue
                else if (wrongGuesses[guessIndex] == guessChar && secret.getOccurances(secretChar) != guess.getOccurances(secretChar))
                    continue
                else if (!rightPositions.containsKey(guessIndex)) {
                    wrongPositions[secretIndex] = secretChar
                    wrongGuesses[guessIndex] = guessChar
                }
            }
        }
    }
    rightPositions.forEach { index, element ->
        if (wrongPositions.containsKey(index))
            wrongPositions.remove(index)
    }
    return Evaluation(rightPositions.size, wrongPositions.size)
}
