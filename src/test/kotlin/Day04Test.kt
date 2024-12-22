import day04.Day04
import utils.Grid
import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {

    private val inputString = """MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MMAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX"""

    @Test
    fun `grids can be read`() {
        val grid = Grid(readLinesFromString(inputString))
        grid.printGrid()

        assertEquals(10, grid.width)
        assertEquals(10, grid.height)
    }

    @Test
    fun `should be able to read grid with start value`(){
        val grid = Grid(readLinesFromString(inputString))
        assertEquals("MASM", grid.rightFrom(6,0).joinToString(""))
        assertEquals("MMMSXXMASM", grid.rightFrom(0,0).joinToString(""))
        assertEquals("AMXSXMAAMM", grid.rightFrom(0,2).joinToString(""))
    }

    @Test
    fun `can call coordinates`(){
        val grid = Grid(readLinesFromString(inputString))
        assertEquals(null, grid.valueAt(Pair(-1,0)))
        assertEquals(null, grid.valueAt(Pair(10,5)))
        assertEquals('M', grid.valueAt(Pair(0,0)))
        assertEquals('X', grid.valueAt(Pair(9,9)))
    }


    @Test
    fun `day04 part1 can be solved`() {
        val day04 = Day04(readLinesFromString(inputString))
        assertEquals(18, day04.solvePt1() )
    }

}
