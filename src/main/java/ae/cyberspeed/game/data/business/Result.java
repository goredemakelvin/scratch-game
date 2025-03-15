package ae.cyberspeed.game.data.business;

import ae.cyberspeed.game.data.config.WinItem;
import lombok.Data;

import java.util.List;

@Data
public class Result {
    private char [][] matrix;
    private String reward;
    private List<WinItem> appliedWinningCombinations;
    private String appliedBonusSymbol;


}
