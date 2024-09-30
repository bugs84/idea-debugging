package cz.vondr.idea.debugging.s090_show_all_objects

import java.lang.Thread.sleep
import kotlin.random.Random

fun main() {
    repeat(20) {
        Thread {
            val counter = Counter()
            repeat(1000) {
                val sleepTime = Random.nextLong(1000)
                sleep(sleepTime)
                counter.increment(sleepTime)
            }
        }.start()
    }
//    sleep(1.days.toJavaDuration())
}

data class Counter(var value: Long = 0) {
    fun increment(increment: Long) {
        val currentThread = Thread.currentThread()
        value += increment // #1 Place breakpoint here - Right click in Variables and "Show <Counter> Objects"
        //    It will display all objects in memory of the same type
        // #2 There is Filter expression. You can write there e.g. "value > 1000"
        //    And then continue debugging and more and more Counters will appear
        // #3 I can object "Add to Watches..." and then use it in conditions
        // #4 I can list all threads
    }
}

/**
 * I can extremely easily look into memory at any time during debugging
 * No heap dump. Just "How memory look like now and now and now"
 */
fun note() {}

