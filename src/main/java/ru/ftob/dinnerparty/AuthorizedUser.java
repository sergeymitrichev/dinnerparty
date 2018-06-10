package ru.ftob.dinnerparty;


import ru.ftob.dinnerparty.model.AbstractBaseEntity;

public class AuthorizedUser {
    private static int id = AbstractBaseEntity.START_SEQ;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

    private AuthorizedUser(int x) {
    }
}