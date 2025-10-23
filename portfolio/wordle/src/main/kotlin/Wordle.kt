// Implement the six required functions here
import java.io.File

private const val WORD_LENGTH = 5
private const val LETTER_NUMBER = 4

fun isValid(word: String): Boolean = word.length == WORD_LENGTH

fun readWordList(filename: String): MutableList<String> {
    val lines = File(filename).readLines().map { it.lowercase() }.toMutableList()
    return lines
}

fun pickRandomWord(words: MutableList<String>): String {
    val removeNumber = (0 until words.size).random()
    return words.removeAt(removeNumber)
}

fun obtainGuess(attempt: Int): String {
    println("Attempt $attempt :")
    while (true) {
        val input = readln()
        if (isValid(input)) {
            return input
        }
        else {
            println("Error, Please enter a word of 5 letters.")
        }
    }
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 0..LETTER_NUMBER) {
        if (guess[i] == target[i]) {
            result.add(1)
        }
        else {
            result.add(0)
        }
    }
    return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    for (i in 0..LETTER_NUMBER) {
        if (matches[i] == 1) {
            print(guess[i])
        }
        else {
            print("?")
        }
    }
}
