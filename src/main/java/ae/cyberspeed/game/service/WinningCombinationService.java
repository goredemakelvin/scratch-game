package ae.cyberspeed.game.service;

import ae.cyberspeed.game.data.config.GameConfig;
import ae.cyberspeed.game.data.config.WinCombinations;
import ae.cyberspeed.game.data.config.WinItem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WinningCombinationService {

    public  boolean checkSameSymbolRightToLeftDiagonal(String[][] matrix) {
        // Method to check right-to-left diagonal for the same symbol
            int rows = matrix.length;
            int cols = matrix[0].length;

            // Check if the matrix is square (required for diagonal check)
            if (rows != cols) {
                System.out.println("Matrix is not square. Cannot check diagonal.");
                return false;
            }

            // Take the first symbol in the right-to-left diagonal as the reference
            String symbol = matrix[0][cols - 1];


            // Check the right-to-left diagonal
            for (int i = 1; i < rows; i++) {
                if (matrix[i][cols - 1 - i] != symbol) {
                    return false;
                }
            }
            return true;
    }

    public Map<WinItem, String> applyWinningCombinations(String[][] matrix, GameConfig config) {
        Set<String> allUnigueStandardSymbols = getAllUnigueStandardSymbols(matrix);
        Map<WinItem, String> winItems = new HashMap();
        WinCombinations winCombinations = config.getWin_combinations();
        allUnigueStandardSymbols.forEach(symbol -> {
            int count = countSymbolsInMatrix(matrix, symbol);
            switch (count) {
                case 3: {
                    winItems.put(winCombinations.getSame_symbol_3_times(), symbol);
                    break;
                }
                case 4: {
                    winItems.put(winCombinations.getSame_symbol_4_times(), symbol);
                    break;
                }
                case 5: {
                    winItems.put(winCombinations.getSame_symbol_5_times(), symbol);
                    break;
                }
                case 6: {
                    winItems.put(winCombinations.getSame_symbol_6_times(), symbol);
                    break;
                }
                case 7: {
                    winItems.put(winCombinations.getSame_symbol_7_times(), symbol);
                    break;
                }
                case 8: {
                    winItems.put(winCombinations.getSame_symbol_8_times(), symbol);
                    break;
                }
                case 9: {
                    winItems.put(winCombinations.getSame_symbol_9_times(), symbol);
                    break;
                }
            }

            boolean exist = sameSymbolsVertically(matrix);
            if (exist) {
                winItems.put(winCombinations.getSame_symbols_vertically(), symbol);
            }

            if (sameSymbolsHorizontally(matrix)) {
                winItems.put(winCombinations.getSame_symbols_horizontally(), symbol);
            }

            if (checkSameSymbolLeftToRightDiagonal(matrix)) {
                winItems.put(winCombinations.getSame_symbols_diagonally_left_to_right(), symbol);
            }

            if (checkSameSymbolRightToLeftDiagonal(matrix)) {
                winItems.put(winCombinations.getSame_symbols_diagonally_right_to_left(), symbol);
            }


        });
        return winItems;

    }

    private Set<String> getAllUnigueStandardSymbols(String[][] matrix) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                set.add(matrix[i][j]);
            }
        }
        return set;
    }

    public int countSymbolsInMatrix(String[][] matrix, String name) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals(name)) {
                    count++;
                }
            }
        }
        return count;

    }

    public boolean sameSymbolsHorizontally(String[][] matrix) {
        for (String[] row : matrix) {
            if (row.length == 0) {
                continue; // Skip empty rows
            }
            String firstSymbol = row[0];
            boolean allSame = true;
            for (String symbol : row) {
                if (!symbol.equals(firstSymbol)) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                return true;
            }
        }
        return false;

    }

    public boolean sameSymbolsVertically(String[][] matrix) {
        if (matrix.length == 0) {
            return false;
        }
        // Determine the maximum column length across all rows
        int maxCols = 0;
        for (String[] row : matrix) {
            if (row.length > maxCols) {
                maxCols = row.length;
            }
        }
        // Check each column up to the maximum column length
        for (int col = 0; col < maxCols; col++) {
            boolean allRowsHaveCol = true;
            // Check if all rows have this column
            for (String[] row : matrix) {
                if (col >= row.length) {
                    allRowsHaveCol = false;
                    break;
                }
            }
            if (!allRowsHaveCol) {
                continue; // Skip columns not present in all rows
            }

            // Check if all elements in this column are the same
            String firstSymbol = matrix[0][col];
            boolean allSame = true;
            for (int row = 0; row < matrix.length; row++) {
                if (!matrix[row][col].equals(firstSymbol)) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSameSymbolLeftToRightDiagonal(String[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // Check if the matrix is square (required for diagonal check)
        if (rows != cols) {
            System.out.println("Matrix is not square. Cannot check diagonal.");
            return false;
        }
        // Take the first symbol as the reference
        String symbol = matrix[0][0];
        // Check the diagonal
        for (int i = 1; i < rows; i++) {
            if (matrix[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

}

