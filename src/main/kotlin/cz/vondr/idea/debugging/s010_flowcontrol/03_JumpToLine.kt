package org.example.cz.vondr.idea.debugging.s01_flowcontrol

import kotlin.random.Random

fun main() {
    JumpToLine().sample()
}

class JumpToLine {
    fun sample() {
        println(method())
    }

    private fun method(): String {
        // #1 install plugin
        if (Random.nextInt() != 123456) { // #2 put breakpoint here
            // #3
            throw Exception("Uups some error")
        }
        return "Jump to line result"
    }

}
