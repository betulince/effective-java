package preferDependencyInjection;

import java.util.ArrayList;
import java.util.List;

/*** This class provides utility methods related to spell checking without needing to be instantiated.
 * Assumes there is only one dictionary worth using. In practice, each language has its own dictionary,
 * and special dictionaries used for special vocabularies.
 * inflexable & untestable
 */
public class SpellCheckerStaticUtility {
    private static final Lexicon dictionary = createLexicon();

    private SpellCheckerStaticUtility() {
        throw new AssertionError("Cannot instantiate SpellCheckerStaticUtility");
    }

    private static Lexicon createLexicon() {
        Lexicon lexicon = new Lexicon();
        lexicon.addEntry("Java", "A high-level programming language.");
        return lexicon;
    }

    public static boolean isValid(String word) {
        return dictionary.getDefinition(word) != null;
    }

    public static List<String> suggestions(String typo) {
        List<String> suggestions = new ArrayList<>();

        for (String word : dictionary.getAllWords()) {
            if (word.startsWith(String.valueOf(typo.charAt(0)))) {
                suggestions.add(word);
            }
        }
        return suggestions;
    }
}
