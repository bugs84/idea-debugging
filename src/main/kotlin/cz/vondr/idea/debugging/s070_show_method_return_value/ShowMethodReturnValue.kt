package cz.vondr.idea.debugging.s070_show_method_return_value

import kotlin.random.Random

fun main() {
    if (giveMeANumber() <= 5) {
        println("Less or equal than five")
    } else {
        println("More than five")
    }
}

fun giveMeANumber(): Int {
    return Random.nextInt(10) // #1 breakpoint here
    // #2 Debugger settings -> "Show Method Return Values"
    // #3 Step out
    // #4 Result of method can bee seen
}

/**
 * It is off by default, because there is small overhead.
 *
 * But overhead is very small, and it can help quite a lot. So you should probably turn it on.
 */
fun note() {}

