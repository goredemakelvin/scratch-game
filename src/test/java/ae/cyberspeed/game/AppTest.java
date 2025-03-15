package ae.cyberspeed.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AppTest {

    private App app;

    @BeforeEach
    @DisplayName("*********SetUp************")
    public void setup() {
        app = new App();
    }


    @Test
    @DisplayName("Test if exception is thrown when params are empty")
    void init() {
        assertThrows(IllegalArgumentException.class, () -> app.init(new String[]{}));
    }
}