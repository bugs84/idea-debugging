package cz.vondr.idea.debugging.s050_exception_breakpoint;

// Idea is, that its often can be good idea to enable Exception Breakpoint
// Then we cannot miss any exception
// BUT we have to properly setup filter

public class ExceptionBreakpoint {

    public static void main(String[] args) {
        startThreadThrowingNumberFormatExceptions();

        while (true) {
            try {
                Thread.sleep(5000);
                throw new SampleApplicationException("Interesting application exception");
            } catch (SampleApplicationException e) {
                // Exception handled
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Handle interrupt exception properly
            }
        }
    }

    public static void startThreadThrowingNumberFormatExceptions() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    throw new NumberFormatException("Not interesting internal exception used to handle valid state");
                } catch (NumberFormatException e) {
                    // Exception handled
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Handle interrupt exception properly
                }
            }
        });
        thread.start();
    }

    public static class SampleApplicationException extends Exception {
        public SampleApplicationException(String message) {
            super(message);
        }
    }
}
