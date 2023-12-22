import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class Day02Test {

    private val sut = Day02()

    @Test
    fun part1() {
        sut.part1(testInput) shouldBe 8
    }

    @Test
    fun part2() {
        sut.part2(testInput) shouldBe 2286
    }

    @ParameterizedTest
    @MethodSource("testInputPart1")
    fun lineValue(input: Pair<String, Int>) {
        sut.lineValuePart1(input.first) shouldBe input.second
    }

    @ParameterizedTest
    @MethodSource("testInputPart2")
    fun lineValuePart2(input: Pair<String, Int>) {
        sut.lineValuePart2(input.first) shouldBe input.second
    }

    companion object {
        val testInput = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
        )

        val expectedResultPart1 = listOf(1, 2, 0, 0, 5)

        val expectedResultPart2 = listOf(48, 12, 1560, 630, 36)

        @JvmStatic
        private fun testInputPart1(): List<Pair<String, Int>> {
            return testInput.zip(expectedResultPart1)
        }

        @JvmStatic
        private fun testInputPart2(): List<Pair<String, Int>> {
            return testInput.zip(expectedResultPart2)
        }

    }
}