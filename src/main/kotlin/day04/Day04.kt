package day04

import utils.Grid

class Day04(private val input: List<String>) {

    private val grid = Grid(input)


    fun solvePt1(): Int {
        val searchStr = "XMAS"
        return 0
    }

    private fun countNonOverlappingOccurrences(str: String, searchStr: String): Int {
        var count = 0
        var startIndex = 0

        while (startIndex < str.length) {
            val index = str.indexOf(searchStr, startIndex)
            if (index >= 0) {
                count++
                startIndex = index + searchStr.length
            } else {
                break
            }
        }

        return count
    }

}