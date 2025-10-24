// Implement the six required functions here
import java.io.File

private const val WORD_LENGTH = 5
private const val LETTER_NUMBER = 4

// check if the word is valid,a valid word have 5 letters
fun isValid(word: String): Boolean = word.length == WORD_LENGTH

// read the list of word from the file
fun readWordList(filename: String): MutableList<String> {
    val lines = File(filename).readLines().map { it.lowercase() }.toMutableList()
    return lines
}

// pick a word from the file and remove it
fun pickRandomWord(words: MutableList<String>): String {
    val removeNumber = (0 until words.size).random()
    return words.removeAt(removeNumber)
}

fun obtainGuess(attempt: Int): String {
    println("Attempt $attempt :")
    while (true) {
        val input = readln()
        if (isValid(input)) {
            // if it is valid,return the guess
            return input
        }
        else {
            println("Error, Please enter a word of 5 letters.")
        }
    }
}

// compaare the guess and the target word
fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = mutableListOf<Int>()
    for (i in 0..LETTER_NUMBER) {
        if (guess[i] == target[i]) {
            result.add(1) // correct letter
        }
        else {
            result.add(0) // incorrect letter
        }
    }
    return result
}

// display the result of the guess
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
