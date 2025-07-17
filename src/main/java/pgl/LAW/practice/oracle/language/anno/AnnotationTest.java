package pgl.LAW.practice.oracle.language.anno;

public class AnnotationTest {
    public @interface MealContainer {
        Meal[] value();
    }

    @java.lang.annotation.Repeatable(MealContainer.class)
    public @interface Meal {
        String value();
        String mainDish();
    }

    @Meal(value="breakfast", mainDish="cereal")
    @Meal(value="lunch", mainDish="pizza")
    @Meal(value="dinner", mainDish="salad")
    public void evaluateDiet() { }
}
