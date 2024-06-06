package singletonProperty;

/*** Singleton with static factory
 * public member is a static factory method
 * all calls to Elvis2.getInstance return the same object reference, and no other Elvis instance will ever be created
 *
 *
 */
public class Elvis2 {
    private static final Elvis2 INSTANCE = new Elvis2();
    private Elvis2() {}
    public static Elvis2 getInstance() {
        return INSTANCE;
    }
    public void leaveTheBuilding() {}

}
