
import day1.Day01
import java.nio.file.Paths
import kotlin.io.path.readLines

fun main() {
    println("Day 1 part 1 solution: ${Day01(readLinesFromFile("2024-01a.txt")).solvePart1()}")
    println("Day 1 part 2 solution: ${Day01(readLinesFromFile("2024-01a.txt")).solvePart2()}")
}


fun readLinesFromFile(fileName: String): List<String> {
    return Paths.get("src", "main", "resources", fileName).readLines()
}

fun readLinesFromString(input: String): List<String> {
    return input.lines()
}