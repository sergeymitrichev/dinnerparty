DELETE FROM user_roles;
DELETE FROM lunch_votes;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM restaurants;
DELETE FROM lunches;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- ID 0,1
INSERT INTO users (email, password) VALUES
  ('user@yandex.ru', 'password'),
  ('admin@gmail.com', 'adminpas');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

-- ID 2, 3
INSERT INTO lunches(date) VALUES
  ('2018-05-30 13:00:00'),
  ('2018-05-31 13:00:00');

-- ID 4, 5
INSERT INTO restaurants(name, lunch_id) VALUES
  ('Ferris', 100002),
  ('Papa Potato', 100002);

-- ID 6, 7, 8, 9, 10
INSERT INTO dishes (name, price, restaurant_id) VALUES
  ('milk', 5, 100004),
  ('soup', 15, 100004),
  ('fish', 25, 100005),
  ('shrimp', 35, 100005),
  ('water', 1, 100005);

INSERT INTO lunch_votes (lunch_id, user_id, restaurant_id) VALUES
  (100002, 100000, 100004),
  (100002, 100001, 100004);