package day01

import kotlin.math.abs

class Day01(private val input: List<String>) {


    fun solvePart1(): Long {

        val(left, right) = parseLists()

        return left.zip(right).map {it.distance()}.sumOf{it.toLong()}
    }

    fun solvePart2(): Long {
        val(left, right) = parseLists()

        return left.sumOf { calculateSimilarity(it, right) }.toLong()
    }

    private fun parseLists(): Pair<List<Int>, List<Int>> = input.map {
        splitLine(it)
    }
        .map { (left, right) -> left.toInt() to right.toInt() }
        .unzip()
        .let { (leftList: List<Int>, rightList: List<Int>) ->
            leftList.sorted() to rightList.sorted()
        }

    private fun calculateSimilarity(element: Int, list: List<Int>): Int {
        return element * list.count{ it == element}
    }

    private fun splitLine(string: String): List<String> = string.trim()
        .split("   ")
    
    private fun Pair<Int, Int>.distance(): Int {
        return abs(this.first - this.second)
    }
}



