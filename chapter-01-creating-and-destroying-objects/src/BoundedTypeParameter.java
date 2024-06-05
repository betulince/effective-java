public class BoundedTypeParameter {

    public static <T extends Number> void getSum(T num1, T num2) { // the method is static so I can directly call it from my main method
        if (num1.getClass().getName().contains("Integer")) { // we use contains() because getClass().getName() returns the whole package -> java.lang.Integer
            int sum = num1.intValue() + num2.intValue();
            System.out.println(sum);
        } else {
            System.out.println("Type is not an integer");
        }
    }

    public static void main(String[] args) {
        BoundedTypeParameter.getSum(10, 20);
    }
}
