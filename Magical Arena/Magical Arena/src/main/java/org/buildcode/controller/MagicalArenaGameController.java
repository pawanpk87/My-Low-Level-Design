package org.buildcode.controller;

import org.buildcode.model.Player;
import org.buildcode.service.MagicalArenaGameService;

public class MagicalArenaGameController {
    private final MagicalArenaGameService magicalArenaGameService;

    public MagicalArenaGameController(MagicalArenaGameService magicalArenaGameService){
        this.magicalArenaGameService = magicalArenaGameService;
    }

    public void play(Player playerA, Player playerB){
        magicalArenaGameService.play(playerA, playerB);
    }
}
