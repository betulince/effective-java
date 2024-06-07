package avoidCreatingUnnecessaryObjects;

/***
 * some object creations are much more expensive than others. If you're going to need such an expensive object repeatedly,
 * it may be advisable to cache it for reuse.
 * the problem with below implementation is that it relies on the String.matches method. and while it's the easiest way to
 * check if a string matches a regular expression, it's not suitable for repeated use in performance-critical situations.
 *
 * it internally creates a Pattern instance for the regular expression and uses it only once,
 * after which it becomes eligible for garbage collection.
 *
 * creating a pattern instance is expensive because it requires compiling the regular expression into a finite state machine.
 * to improve the performance , explicitly compile the regular expression into a Pattern instance (which is immutable)
 * as part of class initialization, cache it, and reuse the same instance for every invocation of the isRomanNumeral method.
 */
public class RomanNumeralsLowPerformance {

    // Performance can be greatly improved!
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}
