package cz.vondr.idea.debugging.s030_tracepoints

var counter = 0

fun main() {
    counter = 1
    addTwo() // #1 Breakpoint and turn off "Suspend"   (possible to do by Shift+click)
    // Tracepoint = breakpoint, that doesn't break
    // Set "Evaluate and log" to "Debug counter=$counter"
    println("Final counter=$counter")
}

fun addTwo() {
    counter += 2
}

// #2 add Tracepoint to field "counter"
//    - it will add where it is called from
//    - we can check "stack trace" and we get even full stacktrace where it was called from
//    - for one/two click we get nice log of places where field counter was modified

/**
 * - I can use Tracepoints **instead of printlns**
 * - I can add Tracepoints to code during debugging  **without recompilation+rerun**
 * - Debugging printlns are part of debugger and not temporal change in code
 * - I cannot **commit debugging printlns by accident**.
 */
fun note() {}