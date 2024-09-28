package cz.vondr.idea.debugging.s010_flowcontrol

fun main() {
    ResetFrame().sample()
}

// RESET/DROP frame
class ResetFrame {
    fun sample() {
        println("Drop frame start")
        // #1 Place breakpoint Here
        val i = 0 // #2 Once it hit breakpoint
        println("Drop frame end")
    }
}
