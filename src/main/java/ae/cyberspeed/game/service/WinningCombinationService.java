package ae.cyberspeed.game.service;

import ae.cyberspeed.game.data.config.GameConfig;
import ae.cyberspeed.game.data.config.WinCombinations;
import ae.cyberspeed.game.data.config.WinItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningCombinationService {

    public List<WinItem> applyWinningCombinations(char[][] matrix, GameConfig config) {
        List<WinItem> winItems = new ArrayList<WinItem>();
        WinCombinations winCombinations = config.getWin_combinations();
        char a = config.getSymbols().getA().getName();
        int count = countSymbolsInMatrix(matrix, a);
        switch (count) {
            case 3: {
                winItems.add(winCombinations.getSame_symbol_3_times());
                break;
            }
            case 4: {
                winItems.add(winCombinations.getSame_symbol_4_times());
                break;
            }
            case 5: {
                winItems.add(winCombinations.getSame_symbol_5_times());
                break;
            }
            case 6: {
                winItems.add(winCombinations.getSame_symbol_6_times());
                break;
            }
            case 7: {
                winItems.add(winCombinations.getSame_symbol_7_times());
                break;
            }
            case 8: {
                winItems.add(winCombinations.getSame_symbol_8_times());
                break;
            }
            case 9: {
                winItems.add(winCombinations.getSame_symbol_9_times());
                break;
            }

        }

     if(sameSymbolsVertically(matrix)){
         winItems.add(winCombinations.getSame_symbols_vertically());
     }

     if(sameSymbolsHorizontally(matrix)){
         winItems.add(winCombinations.getSame_symbols_horizontally());
     }

     if(checkSameSymbolLeftToRightDiagonal(matrix)){
         winItems.add(winCombinations.getSame_symbols_diagonally_left_to_right());
     }

     if(checkSameSymbolRightToLeftDiagonal(matrix)){
         winItems.add(winCombinations.getSame_symbols_diagonally_right_to_left());
     }


        return winItems;

    }

    public int countSymbolsInMatrix(char[][] matrix, char name) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == name) {
                    count++;
                }
            }
        }
        return count;

    }

    public boolean sameSymbolsHorizontally(char[][] matrix) {
        for (char[] row : matrix) {
            if (row.length == 0) {
                continue; // Skip empty rows
            }
            char firstSymbol = row[0];
            boolean allSame = true;
            for (char symbol : row) {
                if (symbol != firstSymbol) {
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

    public  boolean sameSymbolsVertically(char[][] matrix) {
        if (matrix.length == 0) {
            return false;
        }
        // Determine the maximum column length across all rows
        int maxCols = 0;
        for (char[] row : matrix) {
            if (row.length > maxCols) {
                maxCols = row.length;
            }
        }
        // Check each column up to the maximum column length
        for (int col = 0; col < maxCols; col++) {
            boolean allRowsHaveCol = true;
            // Check if all rows have this column
            for (char[] row : matrix) {
                if (col >= row.length) {
                    allRowsHaveCol = false;
                    break;
                }
            }
            if (!allRowsHaveCol) {
                continue; // Skip columns not present in all rows
            }

            // Check if all elements in this column are the same
            char firstSymbol = matrix[0][col];
            boolean allSame = true;
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][col] != firstSymbol) {
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

    public  boolean checkSameSymbolLeftToRightDiagonal(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        Map<Integer, List<Character>> diagonals = new HashMap<>();

        // Group elements by their diagonal (row - column)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int key = i - j;
                diagonals.putIfAbsent(key, new ArrayList<>());
                diagonals.get(key).add(matrix[i][j]);
            }
        }

        // Check each diagonal for all same elements
        for (List<Character> diagonal : diagonals.values()) {
            if (diagonal.isEmpty()) {
                continue;
            }
            char first = diagonal.get(0);
            boolean allSame = true;
            for (char c : diagonal) {
                if (c != first) {
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

    public static boolean checkSameSymbolRightToLeftDiagonal(char[][] matrix) {
        if (matrix.length == 0) {
            return false; // Empty matrix
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Iterate over all possible anti-diagonal sums (k = row + col)
        for (int k = 0; k <= rows + cols - 2; k++) {
            int iStart = Math.max(0, k - (cols - 1)); // Starting row for current diagonal
            int iEnd = Math.min(rows - 1, k);         // Ending row for current diagonal
            int elementCount = iEnd - iStart + 1;

            // Skip diagonals with fewer than 2 elements
            if (elementCount < 2) {
                continue;
            }

            // Check if all elements in the diagonal are the same
            char firstSymbol = matrix[iStart][k - iStart];
            boolean allSame = true;
            for (int i = iStart; i <= iEnd; i++) {
                int j = k - i;
                if (j < 0 || j >= cols || matrix[i][j] != firstSymbol) {
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




}

