package com.spockgeb.tutorial.spock.bank;

import com.spockgeb.tutorial.spock.bank.InsufficientFundsException;

/**
 * Represents a customers bank account.
 */
public class BankAccount {

    private double balance; //all account start of with a balance of zero
    private double allowedOverDraft;//all accounts have a zero value overdraft.
    private boolean isActiveAccount=true;

    /**
     * Customers can deposit funds into their accounts.
     *
     * @param amount - the amount to deposit.
     */
    public void depositFunds(double amount) {
        balance += amount;
    }

    public boolean withdrawAmount(double amount) {
        if ((balance + allowedOverDraft) - amount < 0)
            throw new InsufficientFundsException(balance, amount);
        balance -= amount;
        return true;
    }

    /**
     * Gives the customer a overdraft option.
     *
     * @param allowedOverDraft - the overdraft amount
     */
    public void setAllowedOverDraft(double allowedOverDraft) {
        this.allowedOverDraft = allowedOverDraft;
    }

    /**
     * Returns if the customer is in their overdraft.
     *
     * @return - if the customer is in their overdraft.
     */
    public boolean isInOverdraft() {
        return balance < 0;
    }

    /**
     * Returns the current balance of this account.
     *
     * @return - the current balance
     */
    public double getBalance() {
        return balance;
    }

    public boolean isActiveAccount() {
        return isActiveAccount;
    }

    public void setActiveAccount(boolean activeAccount) {
        isActiveAccount = activeAccount;
    }
}
