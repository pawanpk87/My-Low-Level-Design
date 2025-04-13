package org.buildcode.strategy;

public class RandomRollDiceStrategy implements IRollDiceStrategy{
    private final IRandomGeneratorStrategy randomGeneratorStrategy;

    public RandomRollDiceStrategy(IRandomGeneratorStrategy randomGeneratorStrategy) {
        this.randomGeneratorStrategy = randomGeneratorStrategy;
    }

    @Override
    public Integer rollDie() {
        return randomGeneratorStrategy.getRandomNumber(6);
    }
}