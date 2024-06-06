package preferDependencyInjection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lexicon {
    // vocabulary of a language or branch of knowledge
    // language's inventory of lexemes

    private Map<String, String> entries;

    public Lexicon() {
        entries = new HashMap<>();
    }

    public void addEntry(String word, String definition) {
        entries.put(word, definition);
    }

    public String getDefinition(String word) {
        return entries.get(word);
    }

    public Set<String> getAllWords() {
        return entries.keySet();
    }
}
