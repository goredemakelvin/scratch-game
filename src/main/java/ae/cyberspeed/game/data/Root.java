package ae.cyberspeed.game.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Root{
    private int columns;
    private int rows;
    private Symbols symbols;
    private Probabilities probabilities;
    private WinCombinations win_combinations;
}
