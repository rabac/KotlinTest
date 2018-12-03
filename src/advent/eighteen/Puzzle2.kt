package advent.eighteen

fun main(args: Array<String>) {

    var countTwo = 0
    var countThree = 0

    val allLines = AdventFileReader().readAllLines("/home/rb/IdeaProjects/KotlinTest/src/advent/eighteen/two-1.txt")

    println(allLines.size)
    allLines.forEach {
        val result = parseLine(it)
        countTwo = countTwo.plus(result.two)
        countThree = countThree.plus(result.three)
    }
    println(countTwo)
    println(countThree)
    println(countTwo * countThree)

    var x = 0;

    val sortedLines = allLines.sortedWith(Comparator { p1, p2 ->
       x++
       compare(p1, p2)
    })

    println(sortedLines)
    println(x)

}

fun compare(a: String, b: String): Int {

    var diffIndex = ArrayList<Int>();
    a.forEachIndexed { index,  aChar ->
            if (aChar != b[index]) {
                diffIndex.add(index)
            }
        }
    println(diffIndex.size)

    if (diffIndex.size == 1) {
        println(a)
        println(b)
        return 0
    }
    return a.compareTo(b)
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