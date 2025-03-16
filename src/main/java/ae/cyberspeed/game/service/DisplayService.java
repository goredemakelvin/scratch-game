package ae.cyberspeed.game.service;

import ae.cyberspeed.game.data.business.Bet;

public class DisplayService {

    public void printBetAmount(Bet bet) {
        StringBuilder builder = new StringBuilder();
        builder.append("|------------------------------------------|" + "\n");
        builder.append("|Bet Amount            | " + bet.getBetAmount() + "\n");
        builder.append("|------------------------------------------|" + "\n");
        System.out.print(builder.toString());
    }

    public String[][] generateStandardSymbol(double[][][] probabilities, int rows, int columns) {
        String[][] symbols = new String[rows][columns];
        for (int i = 0; i < probabilities.length; i++) {
            for (int j = 0; j < probabilities[i].length; j++) {
                int maxIndex = findMaxIndex(probabilities[i][j]);
                symbols[i][j] = String.valueOf((char) ('A' + maxIndex));
            }
        }
        return symbols;
    }

    private int findMaxIndex(double[] array) {
        int maxIndex = 0;  // Assume first element is the largest
        // Loop through the array to find the max index
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
