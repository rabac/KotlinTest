package advent.eighteen

import java.io.File

fun readAllLines(fileName: String): List<String> {
    return File(fileName).useLines { it.toList() }
}

fun main(args: Array<String>) {
    val allLines = readAllLines("/home/rb/dev/KotlinTest/src/advent/eighteen/one-1.txt")
    println(finalFrequency(allLines))
    println(finalFrequencyWithRecount(allLines))
}

// TODO refactor this with functional
private fun finalFrequency(allLines: List<String>): Int {
    var currentFrequency = 0
    allLines.forEach {
        val change = it.toInt()
        currentFrequency = currentFrequency + change;
    }
    return currentFrequency
}


private fun finalFrequencyWithRecount(allLines: List<String>): Int {
    var currentFrequency = 0
    var map = HashMap<Int, Int>()
    return getTwiceOccuringFrequency(allLines, currentFrequency, map)
}

private fun getTwiceOccuringFrequency(
    allLines: List<String>,
    currentFrequency: Int,
    map: HashMap<Int, Int>
): Int {
    var currentFrequency = currentFrequency
    allLines.forEach {
        val change = it.toInt()
        currentFrequency = currentFrequency + change;
        val count = map.get(currentFrequency)
        val newCount = (count ?: 0) + 1;
        if (newCount == 2) {
            return currentFrequency
        }
        map.put(currentFrequency, newCount)
    }

    println(map)
    return getTwiceOccuringFrequency(allLines, currentFrequency, map)
}