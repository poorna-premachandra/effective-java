package part1_creating_and_destroying_objects;

//Prefer dependency injection to hard-wiring resources

public class Example5 {

}

class SpellChecker {
    private final String dependency;

    public SpellChecker(String dependency) { //Constructor dependency injection
        this.dependency = dependency;
    }
}