package ae.cyberspeed.game;

import ae.cyberspeed.game.data.config.GameConfig;
import ae.cyberspeed.game.exception.GameBoardException;
import ae.cyberspeed.game.service.GameBoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameBoardTest {
    private GameBoardService gameBoardService;
    private GameConfig gameConfig;

    @BeforeEach
    @DisplayName("*********SetUp************")
    public void setup() {
        gameBoardService = new GameBoardService();
        gameConfig = new GameConfig();
    }

    @Test
    @DisplayName("Test GameBoardException is thrown when columns and rows are <=0")
    void createGameBoard() {
        Throwable exception = assertThrows(GameBoardException.class, () -> {
            gameBoardService.createGameBoard(gameConfig);
        });
        assertEquals(GameBoardException.class, exception.getClass());
    }

    @Test
    @DisplayName("Test GetBoardMatrices Method")
    void getBoardMatrices() {

    }

}