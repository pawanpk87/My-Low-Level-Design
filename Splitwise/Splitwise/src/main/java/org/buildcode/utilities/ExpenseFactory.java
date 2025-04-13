package org.buildcode.utilities;

import org.buildcode.model.Expense;
import org.buildcode.model.User;

import java.util.Map;

public interface ExpenseFactory {
    Expense createExpense(double amount, Map<User, Double> participants);
}
