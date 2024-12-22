package day04

import utils.Grid
import utils.GridDirection

class Day04(input: List<String>) {

    private val grid = Grid(input)


    fun solvePt1(): Int {

        val directions = GridDirection.entries
        val coordinatesOfX = grid.findAllCoordinatesOfValue('X')
        return directions.sumOf { findStuffInDirection(coordinatesOfX, it) }

    }

    private fun findStuffInDirection(coordinatesOfX: List<Pair<Int, Int>>, gridDirection: GridDirection) =
        coordinatesOfX.asSequence().map { grid.nextInDirection(it, gridDirection) }
            .filter { grid.valueAt(it) == 'M' }
            .map { grid.nextInDirection(it, gridDirection) }
            .filter { grid.valueAt(it) == 'A' }
            .map { grid.nextInDirection(it, gridDirection) }.filter { grid.valueAt(it) == 'S' }.count()

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