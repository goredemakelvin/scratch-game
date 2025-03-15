package ae.cyberspeed.game.service;

import ae.cyberspeed.game.data.config.*;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class RewardService {


    public double calculateReward(Map<WinItem, String> winItemMap, double betAmount,
                                  String bonusSymbol, GameConfig gameConfig) {

        for (Map.Entry<WinItem, String> entry : winItemMap.entrySet()) {


            WinItem k = entry.getKey();
            String symbol = entry.getValue();


            if (k instanceof SameSymbol3Times) {
                SameSymbol3Times s3 = (SameSymbol3Times) k;
                betAmount *= s3.getReward_multiplier();

            }
            if (k instanceof SameSymbol4Times) {
                SameSymbol4Times s4 = (SameSymbol4Times) k;
                betAmount *= s4.getReward_multiplier();
            }
            if (k instanceof SameSymbol5Times) {
                SameSymbol5Times s5 = (SameSymbol5Times) k;
                betAmount *= s5.getReward_multiplier();
            }
            if (k instanceof SameSymbol6Times) {
                SameSymbol6Times s6 = (SameSymbol6Times) k;
                betAmount *= s6.getReward_multiplier();
            }
            if (k instanceof SameSymbol7Times) {
                SameSymbol7Times s7 = (SameSymbol7Times) k;
                betAmount *= s7.getReward_multiplier();
            }
            if (k instanceof SameSymbol8Times) {
                SameSymbol8Times s8 = (SameSymbol8Times) k;
                betAmount *= s8.getReward_multiplier();
            }
            if (k instanceof SameSymbol9Times) {
                SameSymbol9Times s9 = (SameSymbol9Times) k;
                betAmount *= s9.getReward_multiplier();
            }
            if (k instanceof SameSymbolsHorizontally) {
                SameSymbolsHorizontally sh = (SameSymbolsHorizontally) k;
                betAmount *= sh.getReward_multiplier();
            }
            if (k instanceof SameSymbolsVertically) {
                SameSymbolsVertically sv = (SameSymbolsVertically) k;
                betAmount *= sv.getReward_multiplier();
            }
            if (k instanceof SameSymbolsDiagonallyLeftToRight) {
                SameSymbolsDiagonallyLeftToRight sv = (SameSymbolsDiagonallyLeftToRight) k;
                betAmount *= sv.getReward_multiplier();
            }
            if (k instanceof SameSymbolsDiagonallyRightToLeft) {
                SameSymbolsDiagonallyRightToLeft sv = (SameSymbolsDiagonallyRightToLeft) k;
                betAmount *= sv.getReward_multiplier();
            }
            betAmount += (betAmount * getRewardMultiplier(symbol, gameConfig));
        }
        betAmount += getBonus(bonusSymbol, betAmount, gameConfig);
        return betAmount;
    }

    private double getRewardMultiplier(String symbol, GameConfig config) {
        StandardSymbol item = new StandardSymbol();
        item.setSymbols(config.getSymbols());
        return item.getRewardMultiplier(symbol);

    }

    private double getBonus(String symbol, double betAmount, GameConfig gameConfig) {
        BonusSymbols bs = new BonusSymbols();
        bs.setSymbols(gameConfig.getSymbols());
        return bs.geBonus(symbol, betAmount);
    }

}
