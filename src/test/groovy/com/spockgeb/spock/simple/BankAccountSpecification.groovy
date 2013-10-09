package com.spockgeb.spock.simple

import com.spockgeb.tutorial.spock.bank.BankAccount
import com.spockgeb.tutorial.spock.bank.InsufficientFundsException
import spock.lang.Specification

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class BankAccountSpecification extends Specification {

    //fields (system under specification)
    def bankAccountWithWelcomeBalance = new BankAccount()

    /**
     * Fixture Method that runs before EVERY feature method
     */
    def setup() {
        //setup the fields to be used in this test.
        bankAccountWithWelcomeBalance.depositFunds(10)  //give everyone a 10 zł welcome fund
    }

    /**
     * 201 - Feature method validating the setup of the account.
     */
    def "New Customers with welcome balance should have a welcome 10 zł balance in their account"() {
        expect:
        bankAccountWithWelcomeBalance.balance == 10
    }

    /**
     *  202  - Feature Method
     */
    def "Check that bank account with welcome balance accepts the correct deposit rate"() {
        when:
        bankAccountWithWelcomeBalance.depositFunds(100)
        then:
        bankAccountWithWelcomeBalance.balance == 110
    }

    /**
     * 203 - Feature Method
     */
    def "Check that bank account accept the correct multi deposits and withdrawals"() {
        given:
        def bankAccount = new BankAccount()
        when: "test a number of deposits and withdrawals"
        bankAccount.depositFunds(100)
        and: "Note the and label"
        bankAccount.withdrawAmount(50)
        and: "Balance should be 50 at this point"
        bankAccount.withdrawAmount(30)
        and: "Balance should be 20 at this point"
        bankAccount.depositFunds(10)
        then: "We should now be left with a balance of 30"
        bankAccount.balance == 30
    }

    /**
     * 203 - Feature Method
     */
    def bankAccount = new BankAccount()

    def "Check that the bank account accepts a deposit"() {
        when: "we deposit 100zl into the the account"
        bankAccount.depositFunds(100)
        then: "expect the old bal. to be 0 and new bal. to be 100"
        old(bankAccount.balance) == 0
        bankAccount.balance == 100
    }

    /**
     *  204 - Feature Method
     */
    def "Check that Authorised Overdrafts work as expected"() {
        setup:
        def bankAccountWithOverdraft = new BankAccount()
        bankAccountWithOverdraft.setAllowedOverDraft(500)
        when: "test a number of deposits and withdrawals"
        bankAccountWithOverdraft.depositFunds(100)
        and: "Note the and label"
        bankAccountWithOverdraft.withdrawAmount(50)
        and: "Balance should be 50 at this point"
        bankAccountWithOverdraft.withdrawAmount(30)
        and: "Balance should be 20 at this point"
        bankAccountWithOverdraft.withdrawAmount(100)
        then: "We should now be left with a balance of 80 overdrawn"
        bankAccountWithOverdraft.isInOverdraft()
        bankAccountWithOverdraft.balance == -80
    }

    /**
     *  - Feature Method
     */
    def "Check that Customer cannot go over their allowed amount"() {
        setup:
        def bankAccountWithOutOverdraft = new BankAccount()
        when: "test a number of deposits and withdrawals"
        bankAccountWithOutOverdraft.depositFunds(100)
        bankAccountWithOutOverdraft.withdrawAmount(110)
        then:
        thrown(InsufficientFundsException)
    }

    /**
     *  - Feature Method
     */
    def "Check that Customer can have a zero balance"() {
        setup:
        def bankAccountWithOutOverdraft = new BankAccount()
        when: "test a number of deposits and withdrawals"
        bankAccountWithOutOverdraft.depositFunds(100)
        bankAccountWithOutOverdraft.withdrawAmount(100)
        then:
        notThrown(InsufficientFundsException)
        bankAccount.balance == 1
    }

    def "Check that Customer can have a balance of total plus 1"() {
        setup:
        def bankAccountWithOutOverdraft = new BankAccount()
        when:
        bankAccountWithOutOverdraft.depositFunds(100)
        then:
        assert bankAccount.balance == 101, "the bank account total should be 101"
    }


}
