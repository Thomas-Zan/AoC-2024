import day01.Day01
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {

    private val inputString = """
        3   4
        4   3
        2   5
        1   3
        3   9
        3   3
    """.trimIndent()

    @Test
    fun `can solve part 1`(){
        val input = readLinesFromString(inputString)

        val result = Day01(input).solvePart1()

        assertEquals(11L, result)
    }

}