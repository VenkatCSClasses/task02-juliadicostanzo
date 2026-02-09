This projects implements a bankAccount class
Each bank account has an email and balance

The backAccount class consists of 8 methods
- constructor
- getBalance
- getEmail
- withdraw
- deposit
- transfer 
- isEmailValid
- isAmountValid


## Constructor
Creates a new back account

Inputs:
- email: a string representing the account email
- startingBalance: a non-negative number with a most two decimal places

Rules:
- Email must be vaild according to isEmailValid
- Starting balance must be valid according to isAmountValid
- If the email is invalid, throw IllegalArgumentException
- If the starting balance is invalid, throw IllegalArgumentException

Output:
- No output (creates a new BankAccount object)


## getBalance
Returns the current balance of the account

Inputs: 
- None

Rules: 
- Does not modify the account

Output:
- The current balance of the account


## getEmail
Returns the email associated with the account

Inputs: 
- None

Rules: 
- Does not modify the account

Output:
- The account's email address


## withdraw
Removes money from the specified account
Inputs:
- amount: a positive number with at most two decimal places
Rules:
- Amount must be valid accroding to isAmountValid
- Amount must be greater than 0 
- Cannot withdraw more than the balance
- If amount is invalid, throw IllegalArgumentExecpetion
- If amount is greater than the balance, throw InsufficientFundsException
Output:
- No outout(balance is reduced) 


## deposit
Adds money to the specified account
Inputs: 
- amount: a positive number with at most two decimal places
Rules:
- Amount must be vaild according to isAmountValid
- AMount must be greater than 0
- If amount is invalid, throw IllegalArgumentException
Output:
- No output(balance is increased)


## transfer
Transfers money from this account to another account.

Inputs:
- to: the destination BankAccount
- amount: a positive number with at most two deciaml places

Rules:
- Amount must be valid accounting to isAmountValid
- Amount must be greater than 0 
- destination account must not be null
- destination account must not be the same as the source account
- Amount to transfer must not be greater than this account balance (must have sufficient funds)
- If destination account is null throw IllegalArgumentException
- If tranfsering to same account, throw IllegalArgumentExeption
- If insufficient funds, thow InsufficientFundsExceptions
- If amount is invalid, throw IllegalArgumentException

Output:
- No output (money is moved between accounts)


## isEmailValid
Checks whether an email address is valid

Inputs:
- email: a string

Rules:
- Email must not be null
- Email cannot be empty
- Email cannot start with a special character (can only start with upper or lowercase charaters or numbers)
- Email must contian at least one "." seperating the domain parts
- Email must contain only one @
- domian must have letters only 

Output:
- True if email is valid 
- False if email is not valid


## isAmountValid
Returns true if amount is positive and has at most 2 decimal places, otherwise returns false

Inputs:
- amount: a positive number with at most two deciaml places

Rules:
- amount cannot be null
- amount must be a non-negative number
- amount must have at most 2 decimal places

Output:
- True if email is valid 
- False if email is not valid