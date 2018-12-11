package advent.eighteen

fun main(args: Array<String>) {
    val allPolymers = AdventFileReader().readAllLines("/home/rb/dev/KotlinTest/src/advent/eighteen/five-1.txt")
    println(allPolymers)

    val polymer = allPolymers[0]
    val fullyReactedPolymer = doReact(polymer)

    println(fullyReactedPolymer.length)
}

fun doReact(polymer: String): String {

    val reactionCriteria: Regex = Regex("aA|bB|cC|dD|eE|fF|gG|hH|iI|jJ|kK|lL|mM|nN|oO|pP|qQ|rR|sS|tT|uU|vV|wW|xX|yY|zZ|Aa|Bb|Cc|Dd|Ee|Ff|Gg|Hh|Ii|Jj|Kk|Ll|Mm|Nn|Oo|Pp|Qq|Rr|Ss|Tt|Uu|Vv|Ww|Xx|Yy|Zz")

    var reactionOccurred = false;
    val reactedPolymer = reactionCriteria.replace(polymer) {
        reactionOccurred = true
        ""
    }

    if(reactionOccurred) {
        return doReact(reactedPolymer)
    }
    return reactedPolymer
}