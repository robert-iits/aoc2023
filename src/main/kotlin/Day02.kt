import kotlin.system.measureTimeMillis

class Day02 {

    private val bag = Bag(redCubes = 12, greenCubes = 13, blueCubes = 14)

    fun part1(input: List<String>) = input.sumOf(::lineValuePart1)

    fun part2(input: List<String>) = input.sumOf(::lineValuePart2)

    fun lineValuePart1(line: String): Int {
        createGame(line).forEach { draft ->
            when {
                draft.color == "red" && draft.quantity > bag.redCubes -> return 0
                draft.color == "green" && draft.quantity > bag.greenCubes -> return 0
                draft.color == "blue" && draft.quantity > bag.blueCubes -> return 0
            }
        }
        return line.split(":").first().filter { it.isDigit() }.toInt()
    }

    fun lineValuePart2(line: String): Int {
        var maxRed = 0
        var maxGreen = 0
        var maxBlue = 0
        createGame(line).forEach { draft ->
            when {
                draft.color == "red" && draft.quantity > maxRed -> maxRed = draft.quantity
                draft.color == "green" && draft.quantity > maxGreen -> maxGreen = draft.quantity
                draft.color == "blue" && draft.quantity > maxBlue -> maxBlue = draft.quantity
            }
        }
        return (maxRed * maxGreen * maxBlue)
    }

    private fun createGame(line: String): List<Draft> {
        val games = line.split(":").last().split(";")
        val drawnCubes = mutableListOf<Draft>()
        games.forEach { game ->
            game.trim().split(",").forEach {
                val drawnCube = it.trim().split(" ")
                val color = drawnCube.last()
                val quantity = drawnCube.first().toInt()
                drawnCubes.add(Draft(color, quantity))
            }
        }
        return drawnCubes
    }

    class Draft(val color: String, val quantity: Int)

    class Bag(val redCubes: Int, val greenCubes: Int, val blueCubes: Int)

}

fun main() {
    val input = readInput("Day02")
    println("duration (ms): " + measureTimeMillis { println("part 1: " + Day02().part1(input)) })
    println("duration (ms): " + measureTimeMillis { println("part 2: " + Day02().part2(input)) })
}