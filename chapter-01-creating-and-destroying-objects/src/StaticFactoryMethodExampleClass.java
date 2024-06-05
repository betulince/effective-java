public class StaticFactoryMethodExampleClass {

    public static Boolean valueOf(boolean b) {
        // Static factory method which is simply a static method that returns an instance of the class
        return b ? Boolean.TRUE : Boolean.FALSE;
        // This method converts a primitive boolean value to its corresponding Boolean object
        // If b is true, it returns Boolean.TRUE
    }

    // A class can provide its clients with static methods instead of public constructors
    // Static methods, unlike constructors, don't require creating a new object each time they're invoked

    public static void main(String[] args) {
        boolean b = true;

        Boolean result = StaticFactoryMethodExampleClass.valueOf(b);
        Class<? extends Boolean> resultType = result.getClass();

        System.out.println("Type of result: " + resultType.getName());
    }
}
