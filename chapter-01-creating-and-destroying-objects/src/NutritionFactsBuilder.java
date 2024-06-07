/**
 * the builder pattern is a good choice when designing classes whose constructors or static factories would have more
 * than a handful of parameters, especially if many of the parameters are optional or of identical type.
 *
 * Pizza(int size) { ... }
 * Pizza(int size, boolean cheese) { ... }
 * Pizza(int size, boolean cheese, boolean pepperoni) { ... }
 * Pizza(int size, boolean cheese, boolean pepperoni, boolean bacon) { ... }
 *
 * this is called the telescoping constructor pattern, the problem is that once constructors are 4 or 5 parameters long
 * it becomes difficult to remember the required order of the parameters as well as what particular constructor you
 * might want in a given situation. One alternative solution is JavaBeans pattern where you call  a constructor with the
 * mandatory params and then call any optional setters after:
 *
 * Pizza pizza = new Pizza(12);
 * pizza.setCheese(true);
 * pizza.setPepperoni(true);
 * pizza.setBacon(true);
 *
 * The better alternative is to use BuilderPattern:
 */
public class NutritionFactsBuilder {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;

        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFactsBuilder build() {
            return new NutritionFactsBuilder(this);
        }
    }

    private NutritionFactsBuilder(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFactsBuilder cocaCola = new Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        System.out.println("Serving size: " + cocaCola.servingSize);
        System.out.println("The amount of sodium that coca cola has: " + cocaCola.sodium);
    }
}
