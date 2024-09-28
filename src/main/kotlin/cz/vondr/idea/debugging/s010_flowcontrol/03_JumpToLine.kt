package cz.vondr.idea.debugging.s010_flowcontrol

import kotlin.random.Random

fun main() {
    JumpToLine().sample()
}

class JumpToLine {
    fun sample() {
        println(method())
    }

    private fun method(): String {
        if (Random.nextInt() != 123456) { // #1 put breakpoint here
            throw Exception("Uups some error")
        }
        return "Jump to line result" // #2 move execution here
    }

    /**
     ### To make it work
     - install plugin [Jump to Line](https://plugins.jetbrains.com/plugin/14877-jump-to-line)
     - To be able to move execution point. Breakpoint must suspend All threads not just current one.
     */
    fun notes() {}
}
