package cz.vondr.idea.debugging.s120_rendering;

import org.jetbrains.annotations.Debug.Renderer;

public class CustomRenderer {
    public static void main(String[] args) {
        PersA personA = new PersA("Alice", 25);
        PersB personB = new PersB("Bob", 30);
        PersC personC = new PersC("Charlie", 35);

        System.out.println(personA);
        System.out.println(personB);
        System.out.println(personC);
    }
}

class PersA {
    private String name;
    private int age;

    public PersA(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class PersB {
    private String name;
    private int age;

    public PersB(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

@Renderer(text = "\"Name \" + name, \"Age \" + age")
class PersC {
    private String name;
    private int age;

    public PersC(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


/**
 * Annotation @Debug.Renderer is one, that doesn't work in Kotlin yet.<br>
 * https://youtrack.jetbrains.com/issue/IDEA-335327/Support-Debug.Renderer-annotation-for-Kotlin-classes
 */
class Note {
}

