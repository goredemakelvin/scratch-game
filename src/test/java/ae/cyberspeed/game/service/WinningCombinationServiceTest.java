package ae.cyberspeed.game.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningCombinationServiceTest {

    private static WinningCombinationService winningCombinationService;
    @BeforeAll
    @DisplayName("*********SetUp************")
    public static void setup() {
        winningCombinationService = new WinningCombinationService();
    }

    @Test
    @DisplayName("Test Winning Combinations")
    void applyWinningCombinations() {

    }

    @Test
    @DisplayName("Test Character Symbols In Matrix")
    void countSymbolsInMatrix() {
        char [][] array= new char[][]{{'C'}};
        int i = winningCombinationService.countSymbolsInMatrix(array, 'C');
        assertEquals(1, i,"Number of items in matrix mismatch expected");
    }

    @Test
    @DisplayName("Test if same symbol exists horizontally in matrix")
    public void sameSymbolsHorizontally(){
        char [][] array= new char[][]{{'C','C'}};
        boolean exist = winningCombinationService.sameSymbolsHorizontally(array);
        assertTrue(exist,"Matrix does not contain same symbols horizontally");
    }


    @Test
    @DisplayName("Test same symbol exist vertically in the matrix")
    public void checkSameSymbolVertically(){
        boolean exist=winningCombinationService.sameSymbolsVertically(new char[][]{{'C','C'},{'C','B'}});
        assertTrue(exist,"Matrix does not contain same symbols vertically");

    }

    @Test
    @DisplayName("Test same symbol exist diagonally left to right in the matrix")
    public void sameSymbolsDiagonallyLeftToRight(){
        boolean exist=winningCombinationService.checkSameSymbolLeftToRightDiagonal(new char[][]{{'C','C'},{'C','C'}});
        assertTrue(exist,"Matrix does not contain same symbol diagonally left to right");

    }

    @Test
    @DisplayName("Test same symbol exist diagonally right to left in the matrix")
    public void sameSymbolsDiagonallyRightToRight(){
        boolean exist=winningCombinationService.checkSameSymbolRightToLeftDiagonal(new char[][]{{'C','C'},{'C','C'}});
        assertTrue(exist,"Matrix does not contain same symbol diagonally right to left diagonally");

    }

}