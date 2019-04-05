Auth(Basic)

Log: admin
Passwd: admin


Add product

{
   "name": "Tablet",
   "products": [
                  {"name": "iPad_Mini", "price": 30000},
                  {"name": "iPad2", "price": 10000},
                  {"name": "iPad_Pro", "price": 100000},
                  {"name": "iPad_Air", "price": 50000}
                  ]
}

Add order

{
   "status": "NEW",
   "totalPrice": 100000,
   "jsession": "erqwreqwerqwer211",
   "items":  [{"quantity":2,"productName": "Macbook", "productPrice": 50000}],
   "owner":{"name":"Alex","email":"alex1999@mail.com","phone":"1123123235324"}
}

Add item to cart

{"quantity":2,"productName": "Macbook", "productPrice": 50000}


Owner for Order commit

POST http://localhost:8080/spring-mvc-app/cart/commit/

{"name":"Alex","email":"alex1999@mail.com","phone":"123235324"} 






