package org.buildcode;

import org.buildcode.enums.SplitType;
import org.buildcode.model.Group;
import org.buildcode.model.Payment;
import org.buildcode.model.User;
import org.buildcode.utilities.GroupExpenseFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User userA = new User();

        User userB = new User();
        User userC = new User();
        User userD = new User();
        User userE = new User();

        // create group
        Group group = userA.createGroup("GroupNameA");

        // send group invitation
        userA.sendGroupInvitation("GroupNameA", Arrays.asList(userB, userC, userD, userE));

        // join group
        userB.joinGroup("GroupNameA");
        userC.joinGroup("GroupNameA");
        userD.joinGroup("GroupNameA");
        userE.joinGroup("GroupNameA");

        // create expense
        userA.createExpense(new GroupExpenseFactory(group, SplitType.EQUAL).createExpense(3400.0, null));

        // create payment
        Payment payment = new Payment();
        userA.settleDebts(payment);
    }
}