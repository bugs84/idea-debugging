package cz.vondr.idea.debugging.s010_flowcontrol

import kotlin.random.Random

fun main() {
    JumpToLine().sample()
}

class JumpToLine {
    fun sample() {
        println(failingCode())
    }

    private fun failingCode(): String {
        if (Random.nextInt() != 123456) { // #1 put breakpoint here
            throw Exception("Oops some error")
        }
        return "Failing code result" // #2 move execution here
    }

    /**
     ### To make it work
     - install plugin [Jump to Line](https://plugins.jetbrains.com/plugin/14877-jump-to-line)
     - To be able to move execution point. Breakpoint must suspend All threads not just current one.
     */
    fun notes() {}
}
