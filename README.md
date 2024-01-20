# Fun Exercise: Financial Technology Application

## Overview
This project involves building a financial technology application based on a predefined API specification. It's a hands-on exercise designed to help you understand and implement financial technology solutions using Java and Spring Boot.

## Prerequisites
Before starting, ensure you have the following tools and resources:
- API Specification: [FinTech Bank API Spec](https://app.swaggerhub.com/apis/DONOTTRACKPRIVATE/fintech-bank/1.0.0?fbclid=IwAR19IFKjVWRPd03z6ll6YDrsgWG4Wk6dZMuiweS67nBxTOhfsdR6gOcLiRU#/account-controller/deposit)
- Git: [Download Git](https://git-scm.com/downloads)
- Java: [Java 17](https://www.oracle.com/java/technologies/downloads/#java17) 
- IDE: [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) (or any IDE compatible with Spring Boot applications)

# Instructions
Your task is to develop a financial technology application in line with the provided [API specification,](https://app.swaggerhub.com/apis/DONOTTRACKPRIVATE/fintech-bank/1.0.0?fbclid=IwAR19IFKjVWRPd03z6ll6YDrsgWG4Wk6dZMuiweS67nBxTOhfsdR6gOcLiRU#/account-controller/deposit). Follow the spec closely to ensure your application meets all requirements.

### Development Guide
- **Database:** The application utilizes an H2 database, accessible at the [H2 Console](http://localhost:8080/h2-console).
- **Schema and Data Initialization:** Schema and initial data are automatically created upon application startup. Relevant files: `schema.sql`, `data.sql` (links to files).
- **Swagger UI:** Once the application starts, you can access the Swagger UI at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html), which includes an example controller for reference.
- **API Specification:** Utilize the generated API spec from SwaggerHub. Configure it in the `application.yml` file under the property `springdoc.swagger-ui.url`.

## Getting Started
1. **Clone the Repository:** Use Git to clone the project repository to your local machine.
2. **Set Up Your Development Environment:** Install Java and set up your preferred IDE.
3. **Run the Application:** Open the project in your IDE and run the application. Ensure that all prerequisites are correctly configured.
4. **Begin Development:** Follow the API specification to develop the application features.