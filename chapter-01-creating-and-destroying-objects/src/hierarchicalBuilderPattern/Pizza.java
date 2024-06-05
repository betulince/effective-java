package hierarchicalBuilderPattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static hierarchicalBuilderPattern.NyPizza.Size.*;
import static hierarchicalBuilderPattern.Pizza.Topping.*;

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
        /***
         * T must be subtype of Builder<T>
         * T has all the properties and methods of Builder<T>.
         * enabling method chaining and ensuring that methods in the builder return the correct type
         */

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping)); // ensure that null values are not added
            return self(); // abstract method designed to be overridden in subclasses to return the correct builder type
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();
        Calzone calzonePizza = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();

        System.out.println("NyPizza toppings: " + nyPizza.toppings.toString());

        if (calzonePizza.isSauceInside()) {
            System.out.println("Calzone Pizza has sauce inside");
        }
    }
}
