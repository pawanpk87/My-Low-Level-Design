package org.buildcode.service;

import org.buildcode.model.Player;
import org.buildcode.strategy.IRollDiceStrategy;

public class FightService {
    private final IRollDiceStrategy rollDiceStrategy;

    public FightService(IRollDiceStrategy rollDiceStrategy){
        this.rollDiceStrategy = rollDiceStrategy;
    }

    public void fight(Player attacker, Player defender){
        int attackRoll = rollDiceStrategy.rollDie();
        int defenseRoll = rollDiceStrategy.rollDie();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;

        int damage = Math.max(0, attackDamage - defenseStrength);
        defender.setHealth(defender.getHealth() - damage);

        System.out.println("Attacker rolls " + attackRoll + ", Defender rolls " + defenseRoll);
        System.out.println("Attack damage: " + attackDamage + ", Defense strength: " + defenseStrength);
        System.out.println("Defender health reduced by " + damage + " to " + defender.getHealth() + "\n");
    }
}