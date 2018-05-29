package ru.ftob.dinnerparty;

import ru.ftob.dinnerparty.model.Dish;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.ftob.dinnerparty.RestaurantTestData.RESTAURANT4;
import static ru.ftob.dinnerparty.RestaurantTestData.RESTAURANT5;
import static ru.ftob.dinnerparty.model.AbstractBaseEntity.START_SEQ;

public class DishTestData {
    public static final int DISH6_ID = START_SEQ + 6;
    public static final int DISH7_ID = START_SEQ + 7;
    public static final int DISH8_ID = START_SEQ + 8;
    public static final int DISH9_ID = START_SEQ + 9;
    public static final int DISH10_ID = START_SEQ + 10;


    public static final Dish DISH6 = new Dish(DISH6_ID, 5, "milk", RESTAURANT4);
    public static final Dish DISH7 = new Dish(DISH7_ID, 15, "soup", RESTAURANT4);
    public static final Dish DISH8 = new Dish(DISH8_ID, 25, "fish", RESTAURANT5);
    public static final Dish DISH9 = new Dish(DISH9_ID, 35, "shrimp", RESTAURANT5);
    public static final Dish DISH10 = new Dish(DISH10_ID, 1, "water", RESTAURANT5);

    public static void assertMatch(Dish actual, Dish expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "lunch");
    }

    public static void assertMatch(Iterable<Dish> actual, Dish... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Dish> actual, Iterable<Dish> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("lunch").isEqualTo(expected);
    }
}
