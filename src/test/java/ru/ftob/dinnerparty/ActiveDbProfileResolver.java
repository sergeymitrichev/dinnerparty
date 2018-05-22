package ru.ftob.dinnerparty;

import org.springframework.test.context.ActiveProfilesResolver;

public class ActiveDbProfileResolver  implements ActiveProfilesResolver {
    @Override
    public String[] resolve(Class<?> aClass) {
        return new String[]{Profiles.getActiveDbProfile()};
    }
}
