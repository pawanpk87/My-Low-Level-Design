package org.buildcode.service;

import org.buildcode.model.Player;

public class MagicalArenaGameService {
    private final FightService fightService;

    public MagicalArenaGameService(FightService fightService){
        this.fightService = fightService;
    }

    public void play(Player playerA, Player playerB){
        while (playerA.getHealth() > 0 && playerB.getHealth() > 0){
            if(playerA.getHealth() < playerB.getAttack()){
                fightService.fight(playerA, playerB);
                if(playerB.getHealth() <= 0) {
                    System.out.println("Player A wins!");
                    break;
                }

                fightService.fight(playerB, playerA);
                if(playerA.getHealth() <= 0) {
                    System.out.println("Player B wins!");
                    break;
                }
            } else{
                fightService.fight(playerB, playerA);
                if (playerA.getHealth() <= 0){
                    System.out.println("Player B wins!");
                    break;
                }

                fightService.fight(playerA, playerB);
                if (playerB.getHealth() <= 0){
                    System.out.println("Player A wins!");
                    break;
                }
            }
        }
    }
}
