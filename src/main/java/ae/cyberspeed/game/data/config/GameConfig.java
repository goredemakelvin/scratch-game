package ae.cyberspeed.game.data.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameConfig {
    private int columns;
    private int rows;
    private Symbols symbols;
    private Probabilities probabilities;
    private WinCombinations win_combinations;
}
