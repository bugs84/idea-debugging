package cz.vondr.idea.debugging.s050_exception_breakpoint

fun main() {
    startThreadThrowingNumberFormatExceptions()

    while (true) {
        Thread.sleep(5000)
        try {
            throw SampleApplicationException("Interesting application excepiton")
        } catch (e: SampleApplicationException) {
            /* Exception handled */
        }
    }

}

fun startThreadThrowingNumberFormatExceptions() {
    Thread {
        while (true) {
            Thread.sleep(100)
            try {
                throw NumberFormatException("Not interesting internal exception used to handle valid state")
            } catch (e: NumberFormatException) {
                /* Exception handled */
            }
        }
    }.start()
}

class SampleApplicationException(message: String?) : Exception(message)