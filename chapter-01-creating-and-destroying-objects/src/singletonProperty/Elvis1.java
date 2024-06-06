package singletonProperty;

/*** Singleton with public final field
 * the private constructor is called only once to initialize the public static final field Elvis1.INSTANCE
 * the lack of a public or protected constructor guarantees a 'monoelvistic' universe: exactly one Elvis instance
 * will exist once the Elvis class is initialized.
 * Caveat:
 * a priviliged client can invoke the private constructor reflectively with the aid of AccessibleObject.setAccessible method.
 * if you need to defend against this attack, modify the constructor to make it throw an exception if it's asked to create a second instance.
  */
public class Elvis1 {
    public static final Elvis1 INSTANCE = new Elvis1();
    private Elvis1() {}
    public void leaveTheBuilding() {}
}

