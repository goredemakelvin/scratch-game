package ae.cyberspeed.game.service;

import ae.cyberspeed.game.data.business.Bet;

public class DisplayService {

    public void printBetAmount(Bet bet){
        StringBuilder builder = new StringBuilder();
         builder.append("|------------------------------------------|"+"\n");
         builder.append("|Bet Amount            | "+bet.getBetAmount()+"\n");
         builder.append("|------------------------------------------|"+"\n");
         System.out.print(builder.toString());
    }
    public char [][] generateStandardSymbol(double[][][] probabilities, int rows, int columns) {
        char[][] symbols = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double[] probabiltyArray = new double[6];
                for (int k = 0; k < 6; k++) {
                    probabiltyArray[k] = probabilities[i][j][k];
                    if (k == 5) {
                        int maxIndex = findMaxIndex(probabiltyArray);
                        symbols[i][j] = (char) ('A' + maxIndex);
                        break;
                    }
                }
            }
        }
        System.out.println("Generated Grid:");
        for (char[] row : symbols) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        return symbols;

    }
    private int findMaxIndex(double[] array) {
        double max = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++)
            if (array[i] > max) {
                index = i;
            }
        return index;
    }

}
