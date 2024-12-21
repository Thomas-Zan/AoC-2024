package utils

class Grid(input: List<String>) {

    val width = input[0].length
    val height = input.size
    private val grid = input.joinToString("") { it.trimEnd() }.toCharArray()

    fun printGrid(){
        for (i in (0 until height* width)) {
            if (i % width == 0) {
                println("   EOL")
            }
            print(grid[i])
        }
    }

    fun valueAt(coordinates: Pair<Int, Int>): Char?{
        if(coordinates.first < 0 || coordinates.first >= width || coordinates.second < 0 || coordinates.second >= height){
            return null
        }
        return grid[index(coordinates)]
    }


    fun nextInDirection(coordinates: Pair<Int, Int>, direction: GridDirection): Pair<Int, Int> {
        return when(direction){
            GridDirection.UP -> Pair(coordinates.first, coordinates.second-1)
            GridDirection.UP_RIGHT -> Pair(coordinates.first + 1, coordinates.second-1)
            GridDirection.RIGHT -> Pair(coordinates.first + 1, coordinates.second)
            GridDirection.DOWN_RIGHT -> Pair(coordinates.first + 1, coordinates.second +1)
            GridDirection.DOWN -> Pair(coordinates.first, coordinates.second +1)
            GridDirection.DOWN_LEFT -> Pair(coordinates.first - 1, coordinates.second +1)
            GridDirection.LEFT -> Pair(coordinates.first - 1, coordinates.second)
            GridDirection.UP_LEFT -> Pair(coordinates.first - 1, coordinates.second -1)
        }
    }


    fun rightFrom(x: Int, y: Int): CharArray {
        val startIndex = index(Pair(x, y))
        return grid.sliceArray(startIndex until startIndex + minOf(width- nthInLine(x), width))
    }

    private fun isAtLeftEdge(index: Int): Boolean {
        return index % width == 0
    }

    private fun isAtRightEdge(index: Int): Boolean {
        return index % (width -1) == 0
    }

    private fun isInNthLine(index: Int, line: Int): Boolean{
        val lowerLineBound = line * width
        val upperLineBound = (line+ 1) * width
        return index in lowerLineBound..< upperLineBound
    }

    private fun isInLastLine(index:Int):Boolean{
        return index in (height * (width -1)) ..< (height * width)
    }


    private fun index(coords:Pair<Int, Int>): Int {
        return coords.second * width + coords.first
    }

    private fun coordinates(index: Int): Pair<Int, Int>{
        return Pair(index % width, index / width)
    }

    private fun nthInLine(x: Int): Int{
        return x % width
    }
}
