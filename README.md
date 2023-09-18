  <h1 align="center">
    <img src = "https://github.com/ThiagoMdO/SpringBoot_Challenge_01_ThiagoMendes/assets/128644651/bde6e273-cd90-4666-ac22-5c0df59b20cd" style="margin-top='30px' width:"50px"">
		<p>Simple project - Back-end - Car Rental - Cars Registration</p>
	</h1> 
 <h1>About 🚗</h1>

 **A challenge was proposed where a registration control for a car company would be created, I used a car rental company as an example**

 **The project Fast and Furious Rental** aims to help manage car registration in the company, improving the efficiency of fleet logistics control.

 ## What does the project do 
 ![DocBrownItWorksGIF](https://github.com/ThiagoMdO/SpringBoot_Challenge_01_ThiagoMendes/assets/128644651/79df6bec-dfe0-4b08-9076-41c2e72f1262)

  It's currently possible to register cars from the brands Ford, Chevrolet, BMW and Volvo
  Information such as chassis, model, brand, color and year of manufacture can be consulted

 ## Tools 🔨
 - [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
 - [Spring Boot](https://start.spring.io/)
 - [MySQL](https://www.mysql.com/downloads/)

  ## How use it ⚙️
  1 . Instal JDK 17, link abolve
  <br/>
  2 . Download Spring, link abolve
  <br/>
  2.2 . Set the configuration Spring, below
  
  ![image](https://github.com/ThiagoMdO/SpringBoot_Challenge_01_ThiagoMendes/assets/128644651/a1f9e4ec-bac7-4115-a92b-a715c019ea0f)
  
  3 . Fork this project
  <br/>
  4 . Configure this code in application.properties
  <br/>
  ```bash
        management.endpoints.web.exposure.include=health,metrics
        spring.datasource.url=jdbc:mysql://localhost:3306/db_car
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.datasource.username=root
        spring.datasource.password=root
        spring.jpa.properties.format_sql=true
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
        spring.jpa.properties.hibernate.format_sql=true
        spring.jpa.hibernate.ddl-auto=create
        spring.jpa.defer-datasource-initialization=true
        spring.jpa.generate-ddl=true
        spring.jpa.show-sql=true
        #car-user@localhost:3306
        
        spring.sql.init.mode=always
   ```
     
  5 . Instal MySQL in your machine, use door 3306
  <br/>
  6 . You need to create a data base with name db_car
  <br>
  7. You can test in your browser at that address:
  <br/>
  ```bash
      #In your browser navigation bar
      localhost:8080/car
  ```  
  7.1 The `data.sql` file in the `resources` package has some cars. If you want to create a new car, edit them or use some tools like Talend API Tester or others.
  <br/>
  7.2 Check if any cars have been created in your database.
  <br/>
  8 . How to get a car. 
      You have to put in your browser navigation bar
  ```bash
      #test_one
      localhost:8080/car/classiId
      
      #For exemplo
      localhost:8080/car/1001

  ```
  9 . How to put a car in the system.
  <br/>
  9.1 Throuth edite the doc data.sql
  <br/>
  9.2 You also use a tool like chrome-extension://aejoelaoggembcahagimdiliamlcdmfm/index.html#requests to add new cars
  <br/>
  9.2.1 use this model to add new cars, in the body
  ```bash
{
	"model": "233",
	"brand": "BMW",
	"color": "Gray",
	"fabricationYear": "1999/2000"
}
  ```
 
