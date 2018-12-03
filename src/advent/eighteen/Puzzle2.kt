package advent.eighteen

fun main(args: Array<String>) {

    var countTwo = 0
    var countThree = 0

    val allLines = AdventFileReader().readAllLines("/home/rb/dev/KotlinTest/src/advent/eighteen/two-1.txt")

    allLines.forEach {
        val result = parseLine(it)
        countTwo = countTwo.plus(result.two)
        countThree = countThree.plus(result.three)
    }
    println(countTwo)
    println(countThree)
    println(countTwo*countThree)
}

fun parseLine(line: String): Count {

    val countTwo = line.groupingBy { it }.eachCount().filter { it.value == 2 }.isNotEmpty()
    val countThree = line.groupingBy { it }.eachCount().filter { it.value == 3 }.isNotEmpty()

    val two = if(countTwo == true) 1 else 0
    val three = if(countThree == true) 1 else 0
    val result = Count(two, three)
    println(result)
    return result
}

data class Count(val two: Int, val three: Int)