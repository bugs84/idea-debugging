package cz.vondr.idea.debugging.s080_object_marking

import java.lang.Thread.sleep
import kotlin.random.Random
import kotlin.time.Duration.Companion.days
import kotlin.time.toJavaDuration

fun main() {
    // #1 Start 20 threads each sleep random time and increment counter by time it slept
    //       - if I put breakpoint to method increment() - each time there will be different thread
    // #2 I want to track work of ONE thread only
    repeat(20) {
        Thread {
            val counter = Counter() // #3 place breakpoint here and create "New Watch" "Thread.currentThread()"
            // #4 !!! right click on watch variable and "Mark Object..." name it "markedThread"
            // This will create Runtime Static variable and store result of expression in it.
            repeat(1000) {
                val sleepTime = Random.nextLong(1000)
                sleep(sleepTime)
                counter.increment(sleepTime)
            }
        }.start()
    }
    sleep(1.days.toJavaDuration())
}

class Counter(var value: Long = 0) {
    fun increment(increment: Long) {
        val currentThread = Thread.currentThread()
        value += increment // #5 The Best Part! - Place breakpoint here, and you can use this marked object in condition
        // write condition "markedThread_DebugLabel == Thread.currentThread()"
        // note: IDE will add suffix "_DebugLabel"
    }
}

/**
 * ### Sum it up
 *
 * **Mark Object** let us create Runtime Static Variable - "We can give object a name"
 *
 * And then we can **use it in conditions**, in "Evaluate expression" ...
 *
 * No more writing hashes of objects to the piece of paper. Simply mark objects you are interested in.
 */
fun note() {}