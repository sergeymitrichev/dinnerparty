DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS lunch_votes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS lunches;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
  START 100000;

CREATE TABLE users
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  email    VARCHAR NOT NULL,
  password VARCHAR NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_name_idx
  ON restaurants (name);

CREATE TABLE lunches
(
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date          TIMESTAMP               NOT NULL,
  restaurant_id INTEGER                 NOT NULL,
  enabled       BOOL DEFAULT TRUE       NOT NULL,
  CONSTRAINT lunches_idx UNIQUE (restaurant_id, date),
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX lunches_unique_restaurant_date_idx
  ON lunches (restaurant_id, date);

CREATE TABLE dishes
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     VARCHAR(255) NOT NULL,
  price    INTEGER      NOT NULL,
  lunch_id INTEGER      NOT NULL,
  FOREIGN KEY (lunch_id) REFERENCES lunches (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX dishes_unique_name_lunch_idx
  ON dishes (name, lunch_id);

CREATE TABLE lunch_votes
(
  lunch_id   INTEGER   NOT NULL,
  lunch_date TIMESTAMP NOT NULL,
  user_id    INTEGER   NOT NULL,
  CONSTRAINT lunch_votes_idx UNIQUE (lunch_date, user_id),
  FOREIGN KEY (lunch_id) REFERENCES lunches (id) ON DELETE CASCADE,
  FOREIGN KEY (lunch_date) REFERENCES lunches (date) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
)