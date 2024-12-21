class Grid(private val lines: List<String>) {

    fun width(): Int {
        return lines.first().length
    }

    fun height(): Int {
        return lines.size
    }

    fun readLineRight(lineNumber: Int): String {
        return lines[lineNumber]
    }

    fun readLineLeft(lineNumber: Int): String {
        return lines[lineNumber].reversed()
    }

    fun readLineDown(lineNumber: Int): String {
        return lines.map { it[lineNumber] }.joinToString()
    }
    fun readLineUp(lineNumber: Int): String {
        return lines.reversed().map { it[lineNumber] }.joinToString()   }

}