package org.buildcode.strategy;

import java.util.Random;

public class RandomNumRandomGeneratorStrategy implements IRandomGeneratorStrategy{
    @Override
    public Integer getRandomNumber(Integer lessThanOrEqualToThis) {
        Random random = new Random();
        return random.nextInt(lessThanOrEqualToThis) + 1;
    }
}
