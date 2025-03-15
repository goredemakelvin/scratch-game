package ae.cyberspeed.game.data.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WinCombinations {
    private SameSymbol3Times same_symbol_3_times;
    private SameSymbol4Times same_symbol_4_times;
    private SameSymbol5Times same_symbol_5_times;
    private SameSymbol6Times same_symbol_6_times;
    private SameSymbol7Times same_symbol_7_times;
    private SameSymbol8Times same_symbol_8_times;
    private SameSymbol9Times same_symbol_9_times;
    private SameSymbolsHorizontally same_symbols_horizontally;
    private SameSymbolsVertically same_symbols_vertically;
    private SameSymbolsDiagonallyLeftToRight same_symbols_diagonally_left_to_right;
    private SameSymbolsDiagonallyRightToLeft same_symbols_diagonally_right_to_left;
}
