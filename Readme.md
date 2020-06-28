![IronHack Logo](https://s3-eu-west-1.amazonaws.com/ih-materials/uploads/upload_d5c5793015fec3be28a63c4fa3dd4d55.png)

# IronHack - Santander - MidTermProject

<p align="center"><strong>Jorge Morales Domínguez</strong></p>

<strong>Index</strong>
* [Requirements](#requirements)
* [Methodology](#methodology)
* [Tools](#tools)
* [How it works](#how-it-works)
* [Documentation](#documentation)
* [Test Coverage](#test-coverage)

## <a name="requirements"></a>Requirements and Instrucitons

###### Requirements
The system must have 4 types of accounts: StudentChecking, Checking, Savings, and CreditCard

Checking
Checking Accounts should have

- a balance
- a secretKey
- a PrimaryOwner
- an optional SecondaryOwner
- a minimumBalance
- a penaltyFee
- a monthlyMaintenanceFee
- a status (FROZEN, ACTIVE)
- StudentChecking

Student Checking Accounts are identical to Checking Accounts except that they do NOT have

- a monthlyMaintenanceFee
- a minimumBalance

Savings

Savings are identical to Checking accounts except that they
do NOT have a monthlyMaintenanceFee
do have an interestRate

CreditCard

CreditCard Accounts have

- a balance
- a PrimaryOwner
- an optional SecondaryOwner
- a creditLimit
- an interestRate
- a penaltyFee

The system must have 3 types of Users: Admins and AccountHolders.

AccountHolders

AccountHolders should be able to login, logout, and access their own account. AccountHolders have:

- a name
- a date of birth
- a primaryAddress (which should be a separate address class)
- an optional mailingAddress

Admins

Admins only have a name

ThirdParty

Third Party Accounts have a hashed key and a name.

Admins can create new accounts. When creating a new account they can create Checking, Savings, or CreditCard Accounts.

Savings

- savings accounts have a default interest rate of 0.0025
- savings accounts may be instantiated with an interest rate other than the default, with a maximum interest rate of 0.5
- savings accounts should have a default minimumBalance of 1000
- savings accounts may be instantiated with a mimimum balance of less than 1000 but no lower than 100

CreditCards

- creditCard accounts have a default creditLimit of 100
- creditCards may be instantiated with a creditLimit higher than 100 but not higher than 100000
- creditCards have a default interestRate of 0.2
- creditCards may be instantiated with an interestRate less than 0.2 but not lower than 0.1

CheckingAcounts

When creating a new Checking account, if the primaryOwner is less than 24, a StudentChecking account should be created otherwise a regular Checking Account should be created.
checking accounts should have a minimumBalance of 250 and a monthlyMaintenanceFee of 12

Interest and Fees should be applied appropriately

PenaltyFee

The penaltyFee for all accounts should be 40.

If any account drops below the minimumBalance, the penaltyFee should be deducted from the balance automatically

Interest Rates

Interest on savings accounts is added to the account annually at the rate of specified interestRate per year. That means that if I have 1000000 in a savings account with a 0.01 interest rate, 1% of 1 Million is added to my account after 1 year. When a savings Account balance is accessed, you must determine if it has been 1 year or more since the either the account was created or since interest was added to the account, and add the appropriate interest to the balance if necessary.

Interest on credit cards is added to the balance monthly. If you have a 12% interest rate (0.12) then 1% interest will be added to the account monthly. When the balance of a credit card is accessed, check to determine if it has been 1 month or more since the account was created or since interested was added, and if so, add the appropriate interest to the balance.

Account Access


Admins

Admins should be able to access the balance for any account, to debit the balance, and to credit the balance.

AccountHolders

AccountHolders should be able to access their own account balance

Account holders should be able to transfer money from any of their accounts to any other account (regardless of owner). The transfer should only be processed if the account has sufficient funds. The user must provide the Primary or Secondary owner name and the id of the account that should receive the transfer.

Third Party Users

There must be a way for third party users to debit and credit accounts.

Third party accounts must be added to the database by an admin.

Third Party users can debit or credit accounts of any type. To do so the must provide their hashed key in the header of the HTTP request. They also must provide the amount, the Account id and the account secret key.

Fraud Detection

The application must recognize patterns that indicate fraud and Freeze the account status when potential fraud is detected.

Patterns that indicate fraud include:

- Transactions made in 24 hours that total to more than 150% of the customers highest daily total transactions in any other 24 hour period.

- More than 2 transactions occuring on a single account within a 1 second period.
Logging

All account access and transactions must be logged in a mongo database with user ids for auditing purposes.

Good Practices

- You must include thorough unit and integration tests.
- You must include robust error handling.
- You must use the Money class for all currency and BigDecimal for any other decimal or large number math.
- You must provide robust logs.

## <a name="methodology"></a>Methodology
For simplicity purpose, a SQL-Generated Entity-Relationship Diagram 
will be displayed to see the relations of the tables and different Entities.

<a href="https://ibb.co/84F2sk5"><img src="https://i.ibb.co/HpmY4Zz/Captura-de-pantalla-de-2020-06-28-15-31-16.png" alt="Captura-de-pantalla-de-2020-06-28-15-31-16" border="0" /></a></p>

## <a name="tools"></a>Tools
- IntelliJ (Compile and run Java Program, JDK 11)
- Spring Boot 
- MySQL
- MongoDB
- Postman
- Swagger (API Document with HTML)

## <a name="how-it-works"></a>How it works
To correctly get the Application up and running, please follow the following steps: 
1. Clone the **Ironhack-MidTermProject** repository on your local computer.

2. Access the folder **"Ironhack-MidTermProject"** in your IntelliJ.

3. Go into your MySQL Workbench and type the following commands ```CREATE SCHEMA mid_term_project```, ```CREATE SCHEMA mid_term_project_test```, 
and run the SQL file to create the databases in your machine.

<a href="https://ibb.co/D8T4qVV"><img src="https://i.ibb.co/BrFL1zz/Captura-de-pantalla-de-2020-06-28-16-03-42.png" alt="Captura-de-pantalla-de-2020-06-28-16-03-42" border="0" /></a>

4. Type the command ```mvn spring-boot:run``` in the terminal of your IntelliJ, as the application runs, 
several entities will be pre-charged for you so you can focus on enjoying the application.
                                  
 5. Open the **Postman** in your terminal and then you can start making requests. 
 The requests allows you to CRUD (**create, read, update and delete**) all entities you desire (Accounts, Transferences, Users).
 
For more information about using Postman, please read the Documentation section below.


## <a name="documentation"></a>Documentation

Postman API test battery that covers the whole functionality of the application. 
Just clicking the button below Postman should open and configure everything automatically. 
To run the tests with Postman, please run the project from the terminal typing: "mvn spring-boot:run" and then
click the button "Runner" as shown below: 

<a href="https://imgbb.com/"><img src="https://i.ibb.co/26xLpxd/Captura-de-pantalla-de-2020-06-28-15-46-43.png" alt="Captura-de-pantalla-de-2020-06-28-15-46-43" border="0" /></a>

Next step is selecting the "Banking System" collection and set the enviroment on 
"IronHack-Santander-MidTermProject".

Ultimately press "Start Run" and enjoy the green field of positive results.

<a href="https://imgbb.com/"><img src="https://i.ibb.co/hFhjcKF/Captura-de-pantalla-de-2020-06-28-15-49-08.png" alt="Captura-de-pantalla-de-2020-06-28-15-49-08" border="0" /></a>


[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/9c67cbceeb4dfe0ca3cf)

* **Swagger**:The documentation for all requests is available in [Swagger](http://localhost:8080/swagger-ui.html) by entering the following link (http://localhost:8080/swagger-ui.html) while having the program rolling in the terminal.

## <a name="test-coverage"></a>Test Coverage

<a href="https://ibb.co/0jcWpFk"><img src="https://i.ibb.co/MDsjyGb/Captura-de-pantalla-de-2020-06-28-15-00-25.png" alt="Captura-de-pantalla-de-2020-06-28-15-00-25" border="0" /></a>
The test coverage with unit and integration tests is <strong>100%</strong> in Classes. 
And <strong>avobe 90%</strong> for Methods and Lines. 
There's a small chance of some tests failing when running the whole application, it that happens,
please run the suites individually and everything should be fine. However, we are working on it :).

 