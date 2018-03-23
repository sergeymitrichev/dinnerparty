#Dinner party 
Voting system for deciding where to have lunch. REST API based on Hibernate/Spring/SpringMVC without frontend.

* [] 2 types of users: admin and regular users
* [] Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
* [] Menu changes each day (admins do the updates)
* [] Users can vote on which restaurant they want to have lunch at
* [] Only one vote counted per user
* [] If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.

## API methods
### Users
#### `GET /users` Return all users

Request:

Name | Type | Default | Description
------------ | ------------- | ------------- | -------------
`page` | `Integer` | `1` | Page number with search results
`limit` | `Integer` | `20` | Users per page 
`filter` | `Object (UserFilter)` |  | 
`filter.name` | `String` |  | User name 

Response:

Name | Type | Description
------------ | ------------- | -------------
`success` | `Boolean` | Request result (success/fail)
`pagination` | `Object (PaginationResponse)` | Users per page 
`pagination.limit` | `Integer` |  
`pagination.totalCount` | `Integer` | 
`pagination.currentPage` | `Integer` |  
`pagination.totalPageCount` | `Integer` |  
`users` | `Array of objects (User)` |  
`user.id` | `Integer` | 
`user.name` | `String` | 
`user.created.` | `DateTime` |  


#### `POST /users/create` Create new user
#### `POST /users/update/{id}` Update exists user by id
#### `DELETE /users/delete/{id}` Delete user by id
 
### Lunches
#### `GET /lunches` Return all lunches
#### `POST /lunches/create` Add new lunch
#### `POST /lunches/update/{id}` Update exists lunch by id
#### `PUT /lunches/vote/{id}` Vote for lunch
#### `DELETE /lunches/delete/{id}` Delete lunch

### Restaurants
#### `GET /restaurants` Return all restaurants
#### `POST /restaurants/create` Add new restaurant
#### `POST /restaurants/update/{id}` Update exists restaurant
#### `DELETE /restaurants/delete/{id}` Delete restaurant

### Menus
#### `GET /menus` Return all menus
#### `POST /menus/create` Add new menu
#### `POST /menus/update/{id}` Update exists menu
#### `DELETE /menus/delete/{id}` Delete menu

### Dishes 
#### `GET /dishes` Return all dishes
#### `POST /dishes/create` Add new dish
#### `POST /dishes/update/{id}` Update exists dish
#### `DELETE /dishes/delete/{id}` Delete dish