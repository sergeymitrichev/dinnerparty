# Dinner party 

Voting system for deciding where to have lunch. REST API based on Hibernate/Spring/SpringMVC without frontend.

* :white_medium_square: 2 types of users: admin and regular users
* :white_medium_square: Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
* :white_medium_square: Menu changes each day (admins do the updates)
* :white_medium_square: Users can vote on which restaurant they want to have lunch at
* :white_medium_square: Only one vote counted per user
* :white_medium_square: If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed
* :white_medium_square: Each restaurant provides new menu each day.

## API methods
### Authorization
#### `POST /login` Log in user
#### `POST /logout` Log out user

### Users

#### `GET /users` Read all users
**For admin only**. Get all users or users filtered by name. 

Request:

Name          | Type                  | Default       | Description
------------  | -------------         | ------------- | -------------
`page`        | `Integer`             | `1`           | Page number with search results
`limit`       | `Integer`             | `20`          | Users per page 
`filter`      | `Object (UserFilter)` |               | 
`filter.name` | `String`              |               | User name 

Response:

Name                        | Type                          | Description
------------                | -------------                 | -------------
`success`                   | `Boolean`                     | Request result (success/fail)
`pagination`                | `Object (PaginationResponse)` | Users per page 
`pagination.limit`          | `Integer`                     |  
`pagination.totalCount`     | `Integer`                     | 
`pagination.currentPage`    | `Integer`                     |  
`pagination.totalPageCount` | `Integer`                     |  
`users`                     | `Array of objects (User)`     |  
`user.id`                   | `Integer`                     | 
`user.name`                 | `String`                      | 
`user.created.`             | `DateTime`                    |  


#### `POST /users/create` Create new user
**For admin only**.
#### `POST /users/update/{id}` Update exists user by id
**For admin only**.
#### `DELETE /users/delete/{id}` Delete user by id
**For admin only**.
 
### Lunches
#### `GET /lunches` Read all lunches
#### `POST /lunches/create` Add new lunch
**For admin only**.
#### `POST /lunches/update/{id}` Update exists lunch by id
**For admin only**.
#### `PUT /lunches/vote/{id}` Vote for lunch
#### `DELETE /lunches/delete/{id}` Delete lunch
**For admin only**.

### Restaurants
#### `GET /restaurants` Read all restaurants
**For admin only**.
#### `POST /restaurants/create` Add new restaurant
**For admin only**.
#### `POST /restaurants/update/{id}` Update exists restaurant
**For admin only**.
#### `DELETE /restaurants/delete/{id}` Delete restaurant
**For admin only**.

### Menus
#### `GET /menus` Read all menus
**For admin only**.
#### `POST /menus/create` Add new menu
**For admin only**.
#### `POST /menus/update/{id}` Update exists menu
**For admin only**.
#### `DELETE /menus/delete/{id}` Delete menu
**For admin only**.

### Dishes 
#### `GET /dishes` Read all dishes
**For admin only**.
#### `POST /dishes/create` Add new dish
**For admin only**.
#### `POST /dishes/update/{id}` Update exists dish
**For admin only**.
#### `DELETE /dishes/delete/{id}` Delete dish
**For admin only**.