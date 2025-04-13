package org.buildcode.strategy;

import org.buildcode.model.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    Map<User, Double> splitExpense(double amount, List<User> participants);
}