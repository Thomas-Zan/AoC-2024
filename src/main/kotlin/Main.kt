
import day01.Day01
import day04.Day04
import java.nio.file.Paths
import kotlin.io.path.readLines

fun main() {
    println("Day 1 part 1 solution: ${Day01(readLinesFromFile("2024-01.txt")).solvePart1()}")
    println("Day 1 part 2 solution: ${Day01(readLinesFromFile("2024-01.txt")).solvePart2()}")
    println("Day 4 part 1 solution: ${Day04(readLinesFromFile("2024-04.txt")).solvePt1()}")
    println("Day 4 part 1 solution: ${Day04(readLinesFromFile("2024-04.txt")).solvePt2()}")
}


fun readLinesFromFile(fileName: String): List<String> {
    return Paths.get("src", "main", "resources", fileName).readLines()
}

fun readLinesFromString(input: String): List<String> {
    return input.lines()
}