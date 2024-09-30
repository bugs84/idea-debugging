package cz.vondr.idea.debugging.s100_filter_collections

fun main() {
    val names = listOf("Alice", "Bob", "Charlie", "David", "Eve", "Frank")

    println(names) // #1 add breakpoint here
    // variables -> right click -> "Filter ..." -> "this.length() > 4"
}

/** Simple feature. I didn't know about it. I used "Evaluate expresion instead" */
fun note() {}