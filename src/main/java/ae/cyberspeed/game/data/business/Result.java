package ae.cyberspeed.game.data.business;

import ae.cyberspeed.game.data.config.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Result {
    private String[][] matrix;
    private double reward;
    private List<WinCombination> appliedWinningCombinations;
    private String appliedBonusSymbol;

    public List<WinCombination> getAppliedWinningCombinations() {
        return appliedWinningCombinations;
    }

    public void setAppliedWinningCombinations(Map<WinItem, String> winItems) {
        List<WinCombination> list = new ArrayList<WinCombination>();

        WinCombination combination = null;

        for (Map.Entry<WinItem, String> entry : winItems.entrySet()) {
            WinItem k = entry.getKey();
            String symbol = entry.getValue();

            if (k instanceof SameSymbol3Times) {
                SameSymbol3Times s3 = (SameSymbol3Times) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(s3.getGroup());
                items.add(s3.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
            if (k instanceof SameSymbol4Times) {
                SameSymbol4Times s4 = (SameSymbol4Times) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(s4.getGroup());
                items.add(s4.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
            if (k instanceof SameSymbol5Times) {
                SameSymbol5Times s5 = (SameSymbol5Times) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(s5.getGroup());
                items.add(s5.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
            if (k instanceof SameSymbol6Times) {
                SameSymbol6Times s6 = (SameSymbol6Times) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(s6.getGroup());
                items.add(s6.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
            if (k instanceof SameSymbol7Times) {
                SameSymbol7Times s7 = (SameSymbol7Times) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(s7.getGroup());
                items.add(s7.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
            if (k instanceof SameSymbol8Times) {
                SameSymbol8Times s8 = (SameSymbol8Times) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(s8.getGroup());
                items.add(s8.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
            if (k instanceof SameSymbol9Times) {
                SameSymbol9Times s9 = (SameSymbol9Times) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(s9.getGroup());
                items.add(s9.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
            if (k instanceof SameSymbolsHorizontally) {
                SameSymbolsHorizontally sh = (SameSymbolsHorizontally) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(sh.getGroup());
                items.add(sh.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
            if (k instanceof SameSymbolsVertically) {
                SameSymbolsVertically sv = (SameSymbolsVertically) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(sv.getGroup());
                items.add(sv.getWhen());
                combination.setDescription(items);
                list.add(combination);


            }
            if (k instanceof SameSymbolsDiagonallyLeftToRight) {
                SameSymbolsDiagonallyLeftToRight sv = (SameSymbolsDiagonallyLeftToRight) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(sv.getGroup());
                items.add(sv.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
            if (k instanceof SameSymbolsDiagonallyRightToLeft) {
                SameSymbolsDiagonallyRightToLeft sv = (SameSymbolsDiagonallyRightToLeft) k;
                combination = new WinCombination();
                combination.setSymbol(symbol);
                List<String> items = new ArrayList<>();
                items.add(sv.getGroup());
                items.add(sv.getWhen());
                combination.setDescription(items);
                list.add(combination);

            }
        }


        this.appliedWinningCombinations = list;


    }
}
