

fun printMessage(parameter: String): Nothing {
    println("Hello $parameter")
    TODO()
}


// Unit is an object - like in Javascript.
// Kotlin has class and we can make objects.
// But you can also make an object, look at Unit code.




fun main(args: Array<String>) {
    val result = printMessage("Hello!")
    //rintln(result)
}

fun TODO2() {
    println()
    throw NotImplementedError()
}



//fun doingSomething(elements: List<String>) : List<Pair<String, Int>> {
//
//    elements.groupBy { it }.map {   }
//}
