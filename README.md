 Backend developer task
Read the requirements below, develop a new OpenAPI 3.0 yaml contract file (contract first approach) and implement a Spring Boot microservice implementing the OpenAPI 3.0 yaml contract. Gradle must be used as a build automation tool. Business logic must be validated using unit tests.
Please get in touch if you have any questions regarding the requirements.
Description
Currency conversion calculation service.
Conversion shall be done in two directions (example with EUR and GBP):
1) Client has some specific amount of EUR and wants to buy GBP. Service returns GBP amount that can be bought.
2) Client wants to buy some specific amount of GBP and wants to know what amount of EUR he needs. Service returns EUR amount that is required to buy a specific amount of GBP.
Sample use cases with EUR and GBP:
1) Client wants to buy some GBP by selling 100.00 EUR.
2) Client wants to buy 100.00 GBP by selling some EUR.
The current baseline rate is 1.2375, i.e. 1.00 GBP = 1.23 EUR. The rate shall be stored in a database, e.g. in H2 in-memory database.
A part of the calculated side (i.e. to GBP in the 1st case, to EUR in the 2nd case) should be taken as profit, this part is called the margin. The margin shall be stored in application parameters (application.yml), use 2% as default value.
Input and output amounts should have 2 decimal places.
Task
Service should return required amount of EUR for the 1st case and calculated amount of GBP in the 2nd case.
What will be evaluated:
- contract design (in contract file)
- data model design
- correct use of abstraction layers (e.g. Controllers and Services)
- code tidiness (formatting, naming, absence of duplication/typos/abbreviations) - test design
Please commit the results to a git repository (Gitlab/Github/our choice) and provide us with access.

 Bonus points for:
- Swagger UI page that can be used to check the service - Correct http codes for client/server errors
Other suggestions:
- take a look at openapi-generator-maven-plugin, it can generate Spring APIs interfaces
automatically
We welcome any question that might arise during the execution of this task.
We don't expect you to spend more than a day on this task.
We will pay €50 if we invite you to the next interview (please also see the mandatory checklist below)
Mandatory checklist:
- Service is implemented using contract-first approach, contract file exists, controllers
use generated classes and interfaces.
- Spring Boot is used.
- Gradle is used.
- Code compiles and runs successfully.
- Both use cases work fine.
- Tests validate business logic and run without errors/failures.
