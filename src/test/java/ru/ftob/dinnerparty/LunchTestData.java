package ru.ftob.dinnerparty;

import ru.ftob.dinnerparty.model.Lunch;
import ru.ftob.dinnerparty.model.Restaurant;

import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.ftob.dinnerparty.RestaurantTestData.RESTAURANT4;
import static ru.ftob.dinnerparty.RestaurantTestData.RESTAURANT5;
import static ru.ftob.dinnerparty.model.AbstractBaseEntity.START_SEQ;

public class LunchTestData {
    public static final int LUNCH2_ID = START_SEQ + 2;
    public static final int LUNCH3_ID = START_SEQ + 3;

    public static final Lunch LUNCH2 = new Lunch(LUNCH2_ID, of(2018, Month.MAY, 30));
    public static final Lunch LUNCH3 = new Lunch(LUNCH3_ID, of(2018, Month.MAY, 31));

    public static void assertMatch(Lunch actual, Lunch expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "votes", "restaurants");
    }

    public static void assertMatch(Iterable<Lunch> actual, Lunch... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Lunch> actual, Iterable<Lunch> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("votes", "restaurants").isEqualTo(expected);
    }
}
