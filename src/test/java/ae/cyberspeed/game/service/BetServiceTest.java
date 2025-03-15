package ae.cyberspeed.game.service;

import ae.cyberspeed.game.exception.InvalidAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BetServiceTest {

    private BetService betService;

    @BeforeEach
    @DisplayName("*********SetUp************")
    public void setup() {
        betService = new BetService();
    }


    @Test
    @DisplayName("Test if method throws exception when negative bet amount is provided")
    void placeBet() {
        Throwable exception = assertThrows(InvalidAmountException.class, () -> {
            betService.placeBet(-20);
        });
        assertEquals(InvalidAmountException.class, exception.getClass());
    }
}