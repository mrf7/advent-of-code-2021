import java.lang.Double.sum

fun main() {

    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { it.first() < it[1] }
    }

    fun part2(input: List<Int>): Int {
        val sums = input.windowed(3) { it.sum()}
        return part1(sums)
    }

// test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test").map(String::toInt)
    check(part1(testInput) == 7)
    check(part2(testInput)== 5) { part2(testInput)}

    val input = readInput("Day01").map(String::toInt)
    println(part1(input))
    println(part2(input))
}