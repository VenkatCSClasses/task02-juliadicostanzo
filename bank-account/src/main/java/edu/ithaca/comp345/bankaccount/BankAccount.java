package edu.ithaca.comp345.bankaccount;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.Pattern;

public class BankAccount {
    private String email;
    private BigDecimal balance;

    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public BankAccount(String email, BigDecimal startingBalance) {
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        if (!isAmountValid(startingBalance)) {
            throw new IllegalArgumentException("Invalid starting balance.");
        }
        this.email = email;
        this.balance = startingBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        if (!isAmountValid(amount) || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        }
        if (amount.compareTo(balance) > 0) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance = balance.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        if (!isAmountValid(amount) || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount.");
        }
        balance = balance.add(amount);
    }

    public void transfer(BankAccount to, BigDecimal amount) throws InsufficientFundsException {
        if (to == null) {
            throw new IllegalArgumentException("Destination account cannot be null.");
        }
        if (this == to) {
            throw new IllegalArgumentException("Cannot transfer to the same account.");
        }
        withdraw(amount);
        to.deposit(amount);
    }

    public static boolean isEmailValid(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isAmountValid(BigDecimal amount) {
        return amount != null && amount.compareTo(BigDecimal.ZERO) >= 0 && 
               amount.scale() <= 2;
    }
}