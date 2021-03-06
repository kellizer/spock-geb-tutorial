package com.spockgeb.tutorial.spock.bank;

/**
 * Thrown when the customer does not have the correct level of funds.
 */
public class InsufficientFundsException extends RuntimeException {

    private double overDrawnBy;
    public InsufficientFundsException(double currentBalance, double requestedAmount) {
        super(String.format("requested withdrawal of %f has been denied, insufficient fund in your account (your balance currently:%f", currentBalance, requestedAmount));
       overDrawnBy = requestedAmount - currentBalance;
    }

    public double getOverDrawnBy() {
        return overDrawnBy;
    }
}
