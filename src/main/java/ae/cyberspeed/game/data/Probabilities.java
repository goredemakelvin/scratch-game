package ae.cyberspeed.game.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Probabilities{
    private ArrayList<StandardSymbol> standard_symbols;
    private BonusSymbols bonus_symbols;
}
