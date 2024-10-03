package cz.vondr.idea.debugging.s020_field_watchpoint

fun main() {
    FieldWatchpoint().sample()
}

class FieldWatchpoint {

    var myField = 0 // #1 put watch point on the field
                    //    Program will stop anywhere in the code, where someone modify/access variable
                    //    Find usages - can return a lot of usages which are not for our case

    fun sample() {
        // #2 property access
        println("Field $myField")

        // #3 property modification
        myField = 10
        println()
        myField = 20
        println()
        myField = 30
    }


}