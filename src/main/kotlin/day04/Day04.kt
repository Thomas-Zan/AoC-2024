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

    fun solvePt2(): Int {
        val coordinatesOfA = grid.findAllCoordinatesOfValue('A')
        val list1 = coordinatesOfA.map { ulToDr(it) }
        val list2 = coordinatesOfA.map { dlToUr(it) }

        val list3 = list1.zip(list2)

        return list3.map { (it.first == "MAS" || it.first == "SAM") && (it.second == "SAM" || it.second == "MAS") }.count { it }

    }

    private fun dlToUr(coords: Pair<Int, Int>): String {
        return grid.valueAt(grid.nextInDirection(coords, GridDirection.DOWN_LEFT))
            .toString() + "A" + grid.valueAt(grid.nextInDirection(coords, GridDirection.UP_RIGHT)).toString()
    }

    private fun ulToDr(coords: Pair<Int, Int>): String {
        return grid.valueAt(grid.nextInDirection(coords, GridDirection.UP_LEFT))
            .toString() + "A" + grid.valueAt(grid.nextInDirection(coords, GridDirection.DOWN_RIGHT)).toString()
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