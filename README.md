# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.8/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.8/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.8/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.8/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### How to add products
cURL
curl --location 'http://localhost:8081/api/v1/product/save' \
--header 'Content-Type: application/json' \
--data '{

        "productName": "BiscutePacks",
        "quantity": 10,
        "price": 10000.0
}'

### How to update data
cURL
curl --location --request PUT 'http://localhost:8081/api/v1/product/update' \
--header 'Content-Type: application/json' \
--data '{
"productId":"104",
"quantity": 80
}'

### How to search products
There are five parameters to search option. All parameters are optional.
* productName - name of the product do you want to search
* minQuantity - Minimum quantity product should have
* maxQuantity - Maximum quantity product should have
* minPrice  - Minimum price product should have
* maxPrice - Maximum price product should have

cURL
curl --location 'http://localhost:8081/api/v1/product/advanceSearch?productName=BiscutePacks&minQuantity=20&maxQuantity=11&minPrice=1000000&maxPrice=100000'