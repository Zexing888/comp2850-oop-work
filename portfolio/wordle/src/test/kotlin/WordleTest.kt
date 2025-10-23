// import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import java.io.File

@Suppress("unused")
class WordleTest : StringSpec({
    "isValid should return true for 5 letters words" {
        isValid("aback") shouldBe true
    }
    "isValid should return false for not 5 letters words" {
        isValid("angery") shouldBe false
        isValid("cat") shouldBe false
    }

    "readWordList should read words from file" {
        val tempFile = File.createTempFile("wordlist", ".txt")
        tempFile.writeText("apple\nbites\nscore")
        val result = readWordList(tempFile.absolutePath)
        result.size shouldBe 3
        result shouldContain "apple"
        result shouldContain "bites"
        result shouldContain "score"
        tempFile.delete()
    }

    "pickRandomWord should return a word from the list" {
        val list = mutableListOf("apple", "aback", "anger")
        val copy = list.toMutableList()
        val word = pickRandomWord(copy)
        list.contains(word) shouldBe true
    }

    "evaluateGuess should have the correct letters as 1 and 0" {
        val guess = "apple"
        val target = "aback"
        val result = evaluateGuess(guess, target)
        result shouldBe listOf(1, 0, 0, 0, 0)
    }
})
