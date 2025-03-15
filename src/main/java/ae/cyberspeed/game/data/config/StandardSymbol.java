package ae.cyberspeed.game.data.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardSymbol {
    private int column;
    private int row;
    private Symbols symbols;

    public int getSymbolTotalProbability() {
        int a = this.getSymbols().getA().getProbability();
        int b = this.getSymbols().getB().getProbability();
        int c = this.getSymbols().getC().getProbability();
        int d = this.getSymbols().getD().getProbability();
        int e = this.getSymbols().getE().getProbability();
        int f = this.getSymbols().getF().getProbability();
        int sum = a + b + c + d + e + f;
        return sum;
    }

    public double getRewardMultiplier(String symbolName) {
        switch (symbolName) {
            case "A": {
                return this.getSymbols().getA().getRewardMultiplier();
            }
            case "B": {
                return this.getSymbols().getB().getReward_multiplier();
            }
            case "C": {
                return this.getSymbols().getC().getReward_multiplier();
            }

            case "D": {
                return this.getSymbols().getD().getReward_multiplier();
            }
            case "E": {
                return this.getSymbols().getE().getReward_multiplier();
            }
            case "F": {
                return this.getSymbols().getF().getReward_multiplier();
            }
            default: {
                return 0;
            }
        }

    }
}
