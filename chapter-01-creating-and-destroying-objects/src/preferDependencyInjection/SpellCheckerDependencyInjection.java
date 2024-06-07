package preferDependencyInjection;

import java.util.Objects;

/**
 * What is required is the ability to support multiple instances of the class (SpellChecker), each of which uses the
 * resource desired by the client (the dictionary).
 * A simple pattern that satisfies this requirement is to pass the resource into the constructor when creating a new
 * instance. This is one form of dependency injection: the dictionary is a dependency of the spell checker and is
 * injected into the spell checker when it is created.
 *
 * Do not use a singleton or static utility class to implement a class that depends on one or more underlying resources
 * whose behaviour affects that of the class, and do not have the class create these resources directly. Instead, pass
 * the resources, or factories to create them, into the constructor (or static factory or builder). This practice, known
 * as dependency injection, will greatly enhance the flexibility, reusability, and testability of a class.
 */
public class SpellCheckerDependencyInjection {
    private final Lexicon dictionary;

    public SpellCheckerDependencyInjection (Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return dictionary.getAllWords() != null;
    }

    // public List<String> suggestions(String typo) {}
}
