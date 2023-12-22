import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


class Day01Test {

    private val sut = Day01()

    @Test
    fun part1() {
        sut.part1(testInputPart1) shouldBe 142
    }

    @Test
    fun part2() {
        sut.part2(testInputPart2) shouldBe 281
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
        val testInputPart1 = listOf(
            "1abc2",
            "pqr3stu8vwx",
            "a1b2c3d4e5f",
            "treb7uchet",
        )

        val expectedResultPart1 = listOf(12, 38, 15, 77)

        val testInputPart2 = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen",
        )

        val expectedResultPart2 = listOf(29, 83, 13, 24, 42, 14, 76)

        @JvmStatic
        private fun testInputPart1(): List<Pair<String, Int>> {
            return testInputPart1.zip(expectedResultPart1)
        }
        @JvmStatic
        private fun testInputPart2(): List<Pair<String, Int>> {
            return testInputPart2.zip(expectedResultPart2)
        }

    }
}