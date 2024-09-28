package cz.vondr.idea.debugging.s010_flowcontrol

fun main() {
    ForceReturn().sample()
}

// RETURN VALUE
class ForceReturn {
    fun sample() {
        println("Returned value: '${method()}'")
    }

    private fun method(): String {
        println("Force return start")
        var count = 0
        count++ // #1 put breakpoint here
        // #2 in debugger use "Force Return" and return "MY $count"
        println("Force return end")
        return "Method result $count"
    }
}
