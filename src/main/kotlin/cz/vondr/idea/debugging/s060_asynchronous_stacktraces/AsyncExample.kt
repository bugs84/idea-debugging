package cz.vondr.idea.debugging.s060_asynchronous_stacktraces

import java.util.Random
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

// https://www.jetbrains.com/help/idea/debug-asynchronous-code.html

fun main() {
    val app = AsyncExample()
    app.createTasks()
    app.executeTasks()
}

class AsyncExample {

    private val tasks = mutableListOf<Task>()
    private val executor: ExecutorService = Executors.newScheduledThreadPool(4)

    fun createTasks() {
        repeat(times = 20) { tasks.add(Task(it)) }
    }

    fun executeTasks() {
        tasks.forEach {
            executor.submit(it)
        }
    }

    class Task(private val num: Int) : Thread() {

        override fun run() {
            sleep(Random().nextInt(2000).toLong())
            printNum()
        }

        private fun printNum() {
            // # 1 Set a breakpoint at the following line
            print("$num ")
        }
    }
}

/**
 *  Idea detect invocation of separate Thread and keep stacktrace a side.
 *
 *  When it is needed it take stack trace and glue it together with current stacktrace.
 *
 *  Async stacktraces work out of the box with **Swing** and **Java Concurrency API**
 *
 *  ### We can create custom Async stacktraces
 *  Using annotations from **org.jetbrains.annotations**
 *
 *  **@Async.Schedule** - Capture stacktrace and object is used as key
 *  **@Async.Execute** - Method where one of the previously stored stack traces is attached to the current stack
 *
 */
fun note() {}

