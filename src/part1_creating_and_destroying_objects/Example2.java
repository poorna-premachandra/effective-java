package part1_creating_and_destroying_objects;

//consider builder when faced with many constructor parameters

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Example2 {

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).fat(2).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola.toString());

        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Pizza.Topping.SAUSAGE).addTopping(Pizza.Topping.ONION).build();
        System.out.println(nyPizza.toString());

        Calzone calzonePizza = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();
        System.out.println(calzonePizza.toString());
    }
}

class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;


    public static class Builder {
        //required parameters
        private final int servingSize;
        private final int servings;

        //optional parameters - initialized to default value
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

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return String.format("CocaCola(serviceSize: %s, servings: %s, calories: %s, fat: %s, sodium: %s, carbohydrate: %s)", servingSize, servings, calories, fat, sodium, carbohydrate);
    }
}


//Another example

abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self(); //subclasses must override this method
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return String.format("%s(toppings: %s with size: %s)", this.getClass().getSimpleName(), Arrays.toString(toppings.toArray()), size);
    }
}

class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; //Default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    @Override
    public String toString() {
        return String.format("%s(toppings: %s with sauce inside: %s)", this.getClass().getSimpleName(), Arrays.toString(toppings.toArray()), sauceInside);
    }
}











