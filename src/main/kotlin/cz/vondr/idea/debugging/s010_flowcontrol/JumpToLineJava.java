
package cz.vondr.idea.debugging.s010_flowcontrol;

import java.util.Random;

public class JumpToLineJava {
    public static void main(String[] args) {
        new JumpToLineJava().sample();
    }

    public void sample() {
        System.out.println(failingCode());
    }

    private String failingCode() {
        if (new Random().nextInt() != 123456) { // #1 put breakpoint here
            throw new RuntimeException("Oops some error");
        }
        return "Failing code result"; // #2 move execution here
    }

    /**
     * ### To make it work
     * - install plugin [Jump to Line](https://plugins.jetbrains.com/plugin/14877-jump-to-line)
     * - To be able to move execution point, the breakpoint must suspend All threads, not just the current one.
     */
    public void notes() {
    }
}