package cz.vondr.idea.debugging.s130_memory_debugging

fun main() {
    val persons = mutableListOf(
        Person("Alice", 25), Person("Bob", 30), Person("David", 40),
        Person("Eve", 22), Person("Charlie", 35), Person("Alice", 28),
    )
    persons.add(Person("Zach", 15)) // #1 Add breakpoint here
    persons.add(Person("Bonnie", 26))

    println(persons) // #2 and add breakpoint Here
}

data class Person(val name: String, val age: Int)


//1. add Memory Panel
//2. I can see all objects in the memory
//3. In memory view search for Person -> right click "Track New Instances"
//4. Go to next breakpoint, you will see Diff for only new instances
//    And you can find there stacktrace where each instance was created.


// Memory debugging can be slow even with fast computer.
// You can turn on "Update Loaded Classes On Debugger Stop" so you do not have to click load classes,
//   but then it will be even slower - so be careful.