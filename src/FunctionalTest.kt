fun main(args: Array<String>) {
    val result = printMessage("Hello!")
    println(result)
}

fun printMessage(parameter: String): Any {
    println("Hello $parameter")
    return "////" + 2
}


// Unit is an object - like in Javascript.
// Kotlin has class and we can make objects.
// But you can also make an object, look at Unit code.





fun TODO2() {

    val words = "one two three four five six seven eight nine ten".split(' ')
    val frequenciesByFirstChar = words.groupingBy { it.first() }.eachCount()

    println(frequenciesByFirstChar)
}



//fun doingSomething(elements: List<String>) : List<Pair<String, Int>> {
//
//    elements.groupBy { it }.map {   }
//}
