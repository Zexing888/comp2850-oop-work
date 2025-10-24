// max attempt
private const val MAX_ATTEMPTS = 10

fun main() {
    val filename = "data/words.txt"
    val wordList = readWordList(filename)

    val targetWord = pickRandomWord(wordList)
    println("Welcom to the Wordle game.")
    // loop for all attempt
    for (i in 1..MAX_ATTEMPTS) {
        val guess = obtainGuess(i)
        val matches = evaluateGuess(guess, targetWord)
        displayGuess(guess, matches)
        if (guess == targetWord) {
            println("victory")
            return
        }
    }
    println("Sorry, you have already use all the attempt, the answer is $targetWord")
}
