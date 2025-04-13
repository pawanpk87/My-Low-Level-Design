package org.buildcode.model;

import org.buildcode.enums.ExpenseType;
import org.buildcode.enums.SplitType;
import org.buildcode.strategy.EqualSplitStrategy;
import org.buildcode.strategy.SplitStrategy;

import java.util.List;
import java.util.Map;

public class GroupExpense extends Expense {
    private Group group;

    public GroupExpense(String expenseId, String description, Double amount, Group group, SplitType splitType) {
        super(expenseId, description, amount, ExpenseType.WITHING_GROUP, splitType);
        this.group = group;
    }

    @Override
    public void calculateShares() {
        // calculate shares
        SplitStrategy strategy = new EqualSplitStrategy();
        List<User> participants = group.getMembers();
        Map<User, Double> shares = strategy.splitExpense(getAmount(), participants);
        setShares(shares);
    }
}