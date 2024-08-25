import org.buildcode.model.Player;
import org.buildcode.service.FightService;
import org.buildcode.service.MagicalArenaGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.MockitoAnnotations;

public class MagicalArenaGameServiceTest {
    @Mock
    private FightService fightService;

    private MagicalArenaGameService magicalArenaGameService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.magicalArenaGameService = new MagicalArenaGameService(fightService);
    }

    @Test
    public void shouldPlayGameWhenBothPlayersHavePositiveHealth() {
        Player playerA = new Player(50, 20, 10);
        Player playerB = new Player(30, 15, 15);

        Mockito.doAnswer(invocation -> {
            Player defender = invocation.getArgument(1);
            defender.setHealth(defender.getHealth() - 10);
            return null;
        }).when(fightService).fight(Mockito.any(), Mockito.any());

        magicalArenaGameService.play(playerA, playerB);

        Mockito.verify(fightService, Mockito.atLeast(1)).fight(Mockito.any(), Mockito.any());
    }
}
