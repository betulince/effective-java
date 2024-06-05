package hierarchicalBuilderPattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/***
 * abstract classes have abstract builders, concrete classes have concrete builders
 */
public abstract class Pizza {

    public enum Topping {
        HAM,
        MUSHROOM,
        ONION,
        PEPPER,
        SAUSAGE
    }

    // holds the toppings of a particular pizza instance
    final Set<Topping> toppings;

    /***
     * Pizza.Builder is a generic type with a recursive type parameter. This, along with the abstract self method, allows
     * method chaining to work properly in subclasses, without the need for casts.
      */
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
