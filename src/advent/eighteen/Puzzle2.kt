package advent.eighteen

fun main(args: Array<String>) {

    var countTwo = 0
    var countThree = 0

    val allLines = AdventFileReader().readAllLines("/home/rb/dev/KotlinTest/src/advent/eighteen/two-1.txt")

    println(allLines.size)
    allLines.forEach {
        val result = parseLine(it)
        countTwo = countTwo.plus(result.two)
        countThree = countThree.plus(result.three)
    }
    println(countTwo)
    println(countThree)
    println(countTwo * countThree)

    allLines.forEachIndexed { index, s ->
        allLines.drop(index).forEach { s2 ->
            if(compare(s, s2)) return@forEach
        }
    }

}

fun compare(a: String, b: String): Boolean {

    var allDiffIndexes = ArrayList<Int>();
    a.forEachIndexed { index, aChar ->
        if (aChar != b[index]) {
            allDiffIndexes.add(index)

        }
    }

    if (allDiffIndexes.size == 1) {

        val diffIndex = allDiffIndexes[0]
        println(a.removeRange(diffIndex, diffIndex+1))
        println(a)
        println(b)
        println(diffIndex)
        return true
    }

    return false
}


fun parseLine(line: String): Count {

    val countTwo = line.groupingBy { it }.eachCount().filter { it.value == 2 }.isNotEmpty()
    val countThree = line.groupingBy { it }.eachCount().filter { it.value == 3 }.isNotEmpty()

    val two = if (countTwo) 1 else 0
    val three = if (countThree) 1 else 0
    val result = Count(two, three)
    println(result)
    return result
}

data class Count(val two: Int, val three: Int)