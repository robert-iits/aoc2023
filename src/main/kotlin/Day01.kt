import kotlin.system.measureTimeMillis

class Day01 {

    fun part1(input: List<String>) = input.sumOf(::lineValuePart1)

    fun part2(input: List<String>) = input.sumOf(::lineValuePart2)

    fun lineValuePart1(line: String): Int {
        val digits = line.filter { it.isDigit() }
        return "${digits.first()}${digits.last()}".toInt()
    }

    fun lineValuePart2(line: String): Int {
        val separatedStringsAndNumbers = line.split(regex = Regex("""\d"""))
        val firstDigit = convertFirstNumberOrNull(separatedStringsAndNumbers.first()) ?: line.first { it.isDigit() }
        val lastDigit = convertLastNumberOrNull(separatedStringsAndNumbers.last()) ?: line.last { it.isDigit() }
        return "$firstDigit$lastDigit".toInt()
    }

    private fun convertFirstNumberOrNull(input: String): Int? {
        var chars = input
        while (chars.length > 2) {
            numberMappingStart(chars)?.let { return it }
            chars = chars.drop(1)
        }
        return null
    }

    private fun convertLastNumberOrNull(input: String): Int? {
        var chars = input
        while (chars.length > 2) {
            numberMappingEnd(chars)?.let { return it }
            chars = chars.dropLast(1)
        }
        return null
    }

    private fun numberMappingStart(numberAsString: String): Int? {
        return when {
            numberAsString.startsWith("one") -> 1
            numberAsString.startsWith("two") -> 2
            numberAsString.startsWith("three") -> 3
            numberAsString.startsWith("four") -> 4
            numberAsString.startsWith("five") -> 5
            numberAsString.startsWith("six") -> 6
            numberAsString.startsWith("seven") -> 7
            numberAsString.startsWith("eight") -> 8
            numberAsString.startsWith("nine") -> 9
            else -> null
        }
    }

    private fun numberMappingEnd(numberAsString: String): Int? {
        return when {
            numberAsString.endsWith("one") -> 1
            numberAsString.endsWith("two") -> 2
            numberAsString.endsWith("three") -> 3
            numberAsString.endsWith("four") -> 4
            numberAsString.endsWith("five") -> 5
            numberAsString.endsWith("six") -> 6
            numberAsString.endsWith("seven") -> 7
            numberAsString.endsWith("eight") -> 8
            numberAsString.endsWith("nine") -> 9
            else -> null
        }
    }

}

fun main() {
    val input = readInput("Day01")
    println("duration (ms): " + measureTimeMillis { println("part 1: " + Day01().part1(input)) })
    println("duration (ms): " + measureTimeMillis { println("part 2: " + Day01().part2(input)) })
}