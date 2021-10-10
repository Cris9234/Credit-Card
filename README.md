# Credit Card

## workflow
### step 1:
1. create a remote repository (RR) on Github
2. clone the RR on Git in order to create a local repository (LR)
3. create a new branch (MyBranch) for committing my code
4. generate a project from https://start.spring.io/ adding the Spring Web dependency
5. create the classes (Card, Numbers, Bank) with their attributes I need to extract information
6. create the classes (Stat, Payload) to do an adapter design pattern
7. create the controller with a GET request where de design pattern is performed

To run the application, just run the CreditCardApplication.java file, go to the browser and type http://localhost:8080/card-scheme/verify/id 
( where id = 6 or 8 digits number)

### step 2:
1. create calss Stat2 to do the design pattern
2. add a HashMap to store the data and a StringList to store the "id" (CardController.java)
3. create the controller with a GET request which requires two parameters

To run the application, just run the CreditCardApplication.java file, go to the browser and type http://localhost:8080/card-scheme/stats?start=a&limit=b 
( where a and b are two integer and a <= b)
