package ru.ftob.dinnerparty;

import ru.ftob.dinnerparty.model.Restaurant;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.ftob.dinnerparty.LunchTestData.LUNCH2;
import static ru.ftob.dinnerparty.LunchTestData.LUNCH3;
import static ru.ftob.dinnerparty.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static final int RESTAURANT4_ID = START_SEQ + 4;
    public static final int RESTAURANT5_ID = START_SEQ + 5;


    public static final Restaurant RESTAURANT4 = new Restaurant(RESTAURANT4_ID, "Ferris", LUNCH2);
    public static final Restaurant RESTAURANT5 = new Restaurant(RESTAURANT5_ID, "Papa Potato", LUNCH2);

    public static void assertMatch(Restaurant actual, Restaurant expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "votes", "dishes");
    }

    public static void assertMatch(Iterable<Restaurant> actual, Restaurant... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Restaurant> actual, Iterable<Restaurant> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("votes", "dishes").isEqualTo(expected);
    }
}
