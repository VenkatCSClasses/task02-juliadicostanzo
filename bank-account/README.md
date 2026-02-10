# Bank Account Project

This project implements a `BankAccount` class that simulates basic banking operations. It includes functionalities for managing an account's balance and email, as well as performing transactions such as deposits, withdrawals, and transfers.

## Project Structure

```
bank-account
├── src
│   ├── main
│   │   └── java
│   │       └── edu
│   │           └── ithaca
│   │               └── comp345
│   │                   └── bankaccount
│   │                       ├── BankAccount.java
│   │                       └── InsufficientFundsException.java
│   └── test
│       └── java
│           └── edu
│               └── ithaca
│                   └── comp345
│                       └── bankaccount
│                           └── BankAccountTest.java
├── pom.xml
└── README.md
```

## BankAccount Class

The `BankAccount` class provides the following methods:

- **Constructor**: Initializes a new bank account with an email and starting balance.
- **getBalance**: Returns the current balance of the account.
- **getEmail**: Returns the email associated with the account.
- **withdraw**: Removes a specified amount from the account balance.
- **deposit**: Adds a specified amount to the account balance.
- **transfer**: Transfers a specified amount from this account to another account.
- **isEmailValid**: Validates the format of the email address.
- **isAmountValid**: Checks if the amount is valid (non-negative and with at most two decimal places).

## InsufficientFundsException Class

The `InsufficientFundsException` class is a custom exception that is thrown when an account does not have enough funds for a withdrawal or transfer operation.

## Testing

The project includes a set of unit tests for the `BankAccount` class, ensuring that all methods function as expected. The tests cover various scenarios, including valid and invalid inputs.

## Running the Tests

To run the tests, use Maven. Navigate to the project directory and execute the following command:

```
mvn test
```

This will compile the project and run all the test cases defined in `BankAccountTest.java`.

## Dependencies

The project uses Maven for dependency management. Ensure that you have Maven installed to build and run the project.