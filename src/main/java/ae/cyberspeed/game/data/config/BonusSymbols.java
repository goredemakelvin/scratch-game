package ae.cyberspeed.game.data.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BonusSymbols {
    private Symbols symbols;

    public int getSymbolTotalProbability() {
        int _500X = this.getSymbols().get_500().getProbability();
        int _5x = this.getSymbols().get_5x().getProbability();
        int _10x = this.getSymbols().get_10x().getProbability();
        int _1000 = this.getSymbols().get_1000().getProbability();
        int sum = _500X + _5x + _10x + _1000;
        return sum;
    }

    public double geBonus(String symbolName, double amount) {
        switch (symbolName) {
            case "+1000": {
                return amount + this.getSymbols().get_1000().getExtra();
            }
            case "+500": {
                return amount + this.getSymbols().get_500().getExtra();
            }
            case "5X": {
                return amount * this.getSymbols().get_5x().getReward_multiplier();
            }

            case "10X": {
                return amount * this.getSymbols().get_10x().getReward_multiplier();
            }
            default: {
                return amount;
            }
        }
    }
}
