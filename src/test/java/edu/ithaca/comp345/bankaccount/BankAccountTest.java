package edu.ithaca.comp345.bankaccount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("user@gmail.com", 100);
    }

    @Test
    void constructor_valid() {
        assertNotNull(account);
        assertEquals("user@gmail.com", account.getEmail());
        assertEquals(100, account.getBalance());
    }

    @Test
    void constructor_zero_starting_balance() {
        BankAccount accountZero = new BankAccount("user@gmail.com", 0);
        assertEquals(0, accountZero.getBalance());
    }

    @Test
    void constructor_null_email() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(null, 100);
        });
        assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void constructor_invalid_email() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("usergmail.com", 100);
        });
        assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    void constructor_invalid_starting_balance_negative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("user@gmail.com", -50);
        });
        assertEquals("Invalid starting balance", exception.getMessage());
    }

    @Test
    void constructor_invalid_starting_balance_decimal() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount("user@gmail.com", 50.9999);
        });
        assertEquals("Invalid starting balance", exception.getMessage());
    }

    @Test
    void getBalance_valid() {
        assertEquals(100, account.getBalance());
    }

    @Test
    void getBalance_zero() {
        BankAccount accountZero = new BankAccount("user@gmail.com", 0);
        assertEquals(0, accountZero.getBalance());
    }

    @Test
    void withdraw_valid_amount() {
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }

    @Test
    void withdraw_exact_balance() {
        account.withdraw(100);
        assertEquals(0, account.getBalance());
    }

    @Test
    void withdraw_insufficient_funds() {
        Exception exception = assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(150);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void deposit_valid_amount() {
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void deposit_negative_amount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-20);
        });
        assertEquals("Invalid amount", exception.getMessage());
    }

    @Test
    void transfer_valid() {
        BankAccount toAccount = new BankAccount("recipient@gmail.com", 50);
        account.transfer(toAccount, 25);
        assertEquals(75, account.getBalance());
        assertEquals(75, toAccount.getBalance());
    }

    @Test
    void transfer_insufficient_funds() {
        BankAccount toAccount = new BankAccount("recipient@gmail.com", 50);
        Exception exception = assertThrows(InsufficientFundsException.class, () -> {
            account.transfer(toAccount, 150);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void isEmailValid_valid() {
        assertTrue(BankAccount.isEmailValid("user@gmail.com"));
    }

    @Test
    void isEmailValid_invalid() {
        assertFalse(BankAccount.isEmailValid("usergmail.com"));
    }

    @Test
    void isAmountValid_valid() {
        assertTrue(BankAccount.isAmountValid(100));
    }

    @Test
    void isAmountValid_invalid() {
        assertFalse(BankAccount.isAmountValid(-50));
    }
}