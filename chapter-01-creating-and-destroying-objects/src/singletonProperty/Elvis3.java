package singletonProperty;

/*** Enum singleton - the preferred approach
 *guarantee against multiple instantiation
 * don't use this approach if your singleton must extend a superclass other than Enum
 */
public enum Elvis3 {
    INSTANCE;
    public void leaveTheBuilding() {}
}
