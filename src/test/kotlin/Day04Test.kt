import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {

    private val inputString = """MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX"""

    @Test
    fun `grids can be read`() {
        val grid = Grid(readLinesFromString(inputString))
        assertEquals(10, grid.width())
        assertEquals(10, grid.height())
    }

}