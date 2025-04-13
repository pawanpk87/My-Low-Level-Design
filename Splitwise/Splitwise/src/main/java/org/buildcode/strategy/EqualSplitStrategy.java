package org.buildcode.strategy;

import org.buildcode.model.User;

import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public Map<User, Double> splitExpense(double amount, List<User> participants) {

        return Map.of();
    }
}