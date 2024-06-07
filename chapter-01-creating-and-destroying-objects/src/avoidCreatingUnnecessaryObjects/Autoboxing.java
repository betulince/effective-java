package avoidCreatingUnnecessaryObjects;

public class Autoboxing {
    /*** Hideously slow because;
     * the variable sum declared as a Long instead of a long, which means the program constructs about 2^31 unnecessary
     * Long instances (roughly one for each time the long i is added to the Long sum).
     * Changing the declaration of sum from Long to long reduces the runtime from 6.3 seconds to 0.59 seconds (on writer's machine)
     *
     * "prefer primitives to boxed primitives, and watch out for unintentional autoboxing"
     *
     * @return sum
     */
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }

        return sum;
    }
}
