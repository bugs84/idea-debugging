package cz.vondr.idea.debugging.s110_stream_debugger

fun main() {
    // Sample with Ints
    val result1 = listOf(10, 87, 97, 43, 121, 20).asSequence() // #1 Breakpoint Here - "Trace Current Stream Chain"
        .flatMap { factorize(it) }
        .distinct()
        .sorted()
        .sum()
    // #2 - There is "Split mode" vs "Flat mode"
    //    - You can go back and forward through the view


    // Sample with objects
    val people = listOf(
        Person("Alice", 25), Person("Bob", 30), Person("David", 40),
        Person("Eve", 22), Person("Charlie", 35), Person("Alice", 28),
    )

    val result2 = people.asSequence()  // #3 Breakpoint Here - "Trace Current Stream Chain"
        .distinctBy { it.name }
        .sortedBy { it.name }
        .map { it.name }
        .map { it.length }
        .sum()
    // #4 Here you can see how objects are displayed. You can expand their properties as usual.
}

data class Person(val name: String, val age: Int)

fun factorize(value: Int): Sequence<Int> = sequence {
    var n = value
    var factor = 2
    while (n > 1) {
        while (n % factor == 0) {
            yield(factor)
            n /= factor
        }
        factor++
    }
}

/**
 * This sample use Kotlin Sequence. Works with Java Streams in the same way.
 *
 *
 */
fun note() {}