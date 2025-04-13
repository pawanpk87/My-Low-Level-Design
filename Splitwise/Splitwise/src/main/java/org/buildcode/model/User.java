package org.buildcode.model;

import org.buildcode.utilities.ExpenseDashboard;
import org.buildcode.utilities.GroupFunctionByUser;

import java.util.List;

public class User extends Person implements GroupFunctionByUser {
    private String userId;
    private Account account;

    private List<Group> groups;
    private ExpenseDashboard dashboard;

    public void createExpense(Expense expense) {
        // create expense
        expense.calculateShares();
        dashboard.addExpense(expense);
        // send notification using NotificationServiceFacade
    }

    public void settleDebts(Payment payment) {
        // settle debts
        dashboard.recordPayment(payment);
    }

    @Override
    public Group createGroup(String groupName) {
        // create group
        return null;
    }

    @Override
    public void joinGroup(String groupName) {
        // join group
    }

    @Override
    public void sendGroupInvitation(String groupName, List<User> users) {
        // send group invitation
    }
}