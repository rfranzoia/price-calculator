# Price Calculation API

A small project that calculates total prices of products and quantities.
 
uses:
* Java 17
* Spring Boot 3.1.0
* Spring Framework 6.0.9
* Support for Docker
* H2 Database

When properly build into the docker container the application will run into something like `http://<server-ip>:8080/price-calcullator`

With `Maven` and `Docker` installed in the target machine run the following commands into a termina:

* `mvn clean package`
* `docker build --tag=price-calculator:latest`
* `docker run -p8080:8080 price-calculator:latest`

### Usage

assuming the base URL mentioned before `http://<server-ip>:8080/price-calcullator`


Products

    Retrieve
        all: Method:GET, Url: `/products`
        one: `/products/UUID`
            UUD is the UUID of the product you want to retrieve

    Create
        Method: POST, Url: `/products`
        BodyContent: 
            {
                name: "name of the product",
                price: 12345678.90
            }

    Delete
        Method: DELETE, Url: /products/UUID`
            UUD is the UUID of the product you want to delete

    Update
        Method: PUT, Url: /products/UUID`
            UUD is the UUID of the product you want to update
        BodyContent: 
            {
                name: "name of the product",
                price: 12345678.90
            }

'

Discount Rules
'

    Retrieve
        all: Method:GET, Url: `/discount-rules`
        one: `/discount-rules/id`
        ID is the ID of the Discount Rule you want to retrieve

    Create
        Method: POST, Url: `/discount-rules`
        BodyContent: 
            {
                type: "AMOUNT" or "PERCENT"
                product: "UUID of the product"
                minQuantity: minimum quantity for the rule to be applied
                amount: the value to be applied as discount
            }

    Delete
        Method: DELETE, Url: /discount-rules/ID`
            UUD is the UUID of the Discount Rule you want to delete

    Update
        Method: PUT, Url: /discount-rules/ID`
            UUD is the UUID of the Discount Rule you want to update
        BodyContent: 
            {
                minQuantity: minimum quantity for the rule to be applied
                amount: the value to be applied as discount
            }
'


Price Calculation

    One Product
        Method: GET, Url: `/price-calculations/product/UUID/quantity/9999`
        Method: POST, Url: ´/price-calculations/product-item´
        BodyContent: 
            {
                uuid: "uuid of the product",
                quantity: 9999999
            }

    List of PRoducts
        methos: POST, Url: `/price-calculations/product-list`
        BodyContent: 
            [{
                uuid: "uuid of the product",
                quantity: 9999999
            }, ...]