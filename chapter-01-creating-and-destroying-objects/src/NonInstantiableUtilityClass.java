public class NonInstantiableUtilityClass {
    // Suppress default constructor for noninstantiability
    private NonInstantiableUtilityClass() {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        try {
            NonInstantiableUtilityClass object = new NonInstantiableUtilityClass();
        } catch (AssertionError e) {
            System.out.println("This class is non-instantiable, therefore an Assertion error caught: " + e);
        }
    }
}
