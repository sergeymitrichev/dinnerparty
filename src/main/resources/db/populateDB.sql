DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM dishes;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- ID 1,2
INSERT INTO users (email, password) VALUES
  ('user@yandex.ru', 'password'),
  ('admin@gmail.com', 'adminpas');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

-- ID 3,4
INSERT INTO restaurants (name) VALUES
  ('Ferris'),
  ('Papa Potato');

-- ID 5,6
INSERT INTO lunches(date, restaurant_id) VALUES
  ('2018-05-30 13:00:00', 3);
  ('2018-05-30 13:00:00', 4);

-- ID 5,6
INSERT INTO dishes (name, price, lunch_id) VALUES
  ('milk',5, 5),
  ('soup',15, 6);

INSERT INTO lunch_votes (lunch_id, lunch_date, user_id) VALUES
  (5,'2018-05-30 13:00:00', 1),
  (6,'2018-05-30 13:00:00', 2);