package org.buildcode.model;

import org.buildcode.enums.ExpenseType;
import org.buildcode.enums.SplitType;

import java.util.HashMap;
import java.util.Map;

public abstract class Expense {
    private String expenseId;
    private String description;
    private Double amount;

    private Map<User, Double> shares;

    private ExpenseType expenseType;
    private SplitType splitType;

    private String createdAt;

    public Expense(String expenseId, String description, Double amount, ExpenseType expenseType, SplitType splitType) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.shares = new HashMap<>();
        this.expenseType = expenseType;
        this.splitType = splitType;
        this.createdAt = "createdAt";
    }

    public abstract void calculateShares();

    public void setShares(Map<User, Double> shares) {
        this.shares = shares;
    }

    public Map<User, Double> getShares() {
        return this.shares;
    }

    public double getAmount() {
        return this.amount;
    }
}