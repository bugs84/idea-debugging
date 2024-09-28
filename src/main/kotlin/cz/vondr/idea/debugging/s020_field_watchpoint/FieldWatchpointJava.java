package cz.vondr.idea.debugging.s020_field_watchpoint;

public class FieldWatchpointJava {

    private int myField = 0; // #1 put watch point on the field and Add there Condition - Only when you read value and it is 10
    // Unfortunately I am not able to break when someone is setting value to 20, because in condition field has value before modification

    public static void main(String[] args) {
        new FieldWatchpointJava().sample();
    }

    public void sample() {
        // property access
        System.out.println("Field " + myField);

        // property modification
        myField = 10;

        // property modification
        myField = 20;

        // property modification
        myField = 30;
    }
}
