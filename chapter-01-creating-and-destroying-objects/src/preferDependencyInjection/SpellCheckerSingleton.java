package preferDependencyInjection;

import java.util.ArrayList;
import java.util.List;

public class SpellCheckerSingleton {

    private final Lexicon dictionary = createLexicon();

    private SpellCheckerSingleton() {
        throw new AssertionError("Cannot instantiate SpellCheckerStaticUtility");
    }

    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    public static SpellCheckerSingleton getInstance() {
        return INSTANCE;
    }

    private Lexicon createLexicon() {
        Lexicon lexicon = new Lexicon();
        lexicon.addEntry("Java", "A high-level programming language."); // just an example
        return lexicon;
    }

    public boolean isValid(String word) {
        return dictionary.getDefinition(word) != null;
    }

    public List<String> suggestions(String typo) {
        List<String> suggestions = new ArrayList<>();

        for (String word : dictionary.getAllWords()) {
            if (word.startsWith(String.valueOf(typo.charAt(0)))) {
                suggestions.add(word);
            }
        }
        return suggestions;
    }
}
