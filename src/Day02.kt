fun main() {
    fun part1(input: List<String>): Int {
        return input.fold(0 to 0) { pos, move ->
            val (dir, dist) = move.split(" ")
            when (dir.lowercase()) {
                "forward" -> pos.first + dist.toInt() to pos.second
                "up" -> pos.first to pos.second - dist.toInt()
                "down" -> pos.first to pos.second + dist.toInt()
                else -> error("fuck")
            }
        }.run { first * second }
    }

    fun part2(input: List<String>): Int {
        return input.fold(Triple(0, 0, 0)) { pos, move ->
            val (dir, dist) = move.split(" ").run { first() to this[1].toInt() }
            val (horiz, depth, aim) = pos
            when (dir.lowercase()) {
                "forward" -> Triple(horiz + dist, depth + (aim * dist), aim)
                "up" -> Triple(horiz, depth, aim - dist)
                "down" -> Triple(horiz, depth, aim + dist)
                else -> error("fuck")
            }
        }.also { println(it) }.run { first * second }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150) { part1(testInput) }
    check(part2(testInput) == 900) { part2(testInput) }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
