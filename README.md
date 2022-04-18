# burrito-ordering-service
This project contains:

1. Order Controller with Rest API endpoints
2. Service Class -may contain business logic
3. Model
   1. Order (Entity)
   2. Vegetable (Entity)
   3. Extras (Entity)
   4. Salsa (ENUM)
   5. Tortilla (ENUM)
4. Order Repository (saves data to h2 in-memory database)
5. JWT Based API Security
6. Junit Test cases
6. Postman Collection
   1. Execute Get /authentication first to get token
   2. Execute POST /orders to save orders
   3. Execute GET /orders/{id} to get order by order id
   4. Execute GET /orders to get all orders
   

#Note: Order_Details_Vegetable and Order_Details_extras could have been modeled better as Vegetable and Extras as Lookup tables. Order_Details_Vegetable and Order_Details_extras as one-to-many relation with order 




