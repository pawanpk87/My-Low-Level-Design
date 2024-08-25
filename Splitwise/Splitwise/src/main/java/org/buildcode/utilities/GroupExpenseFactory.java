package org.buildcode.utilities;

import org.buildcode.enums.SplitType;
import org.buildcode.model.Expense;
import org.buildcode.model.Group;
import org.buildcode.model.GroupExpense;
import org.buildcode.model.User;
import org.buildcode.utilities.ExpenseFactory;

import java.util.Map;

public class GroupExpenseFactory implements ExpenseFactory {
    private Group group;
    private SplitType splitType;

    public GroupExpenseFactory(Group group, SplitType splitType) {
        this.group = group;
        this.splitType = splitType;
    }

    @Override
    public Expense createExpense(double amount, Map<User, Double> participants) {
        String expenseId = "expenseId";
        String description = "Group expense for " + group.getName();
        return new GroupExpense(expenseId, description, amount, group, splitType);
    }
}