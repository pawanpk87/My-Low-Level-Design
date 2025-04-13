package org.buildcode.utilities;

import org.buildcode.model.Expense;
import org.buildcode.model.Payment;
import org.buildcode.model.User;

import java.util.HashMap;
import java.util.Map;

public class ExpenseDashboard {
    private Map<User, Double> owedToOthers;
    private Map<User, Double> othersOwedToUser;

    public ExpenseDashboard() {
        owedToOthers = new HashMap<>();
        othersOwedToUser = new HashMap<>();
    }

    public void addExpense(Expense expense) {
        Map<User, Double> shares = expense.getShares();
        // ...
    }

    public void recordPayment(Payment payment) {
        // Record payment
    }
}