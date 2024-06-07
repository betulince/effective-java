import java.util.*;

public class IteratorExample {

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("Raspberry");
        items.add("Blackberry");
        items.add("Blueberry");
        Iterator<String> iter = items.iterator();

        while (iter.hasNext()) {
            String next = iter.next();
            if ("Blueberry".equals(next)) {
                iter.remove();
            }
        }
        System.out.println(items);
    }
}
