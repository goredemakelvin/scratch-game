package ae.cyberspeed.game.service;

import ae.cyberspeed.game.data.config.GameConfig;
import ae.cyberspeed.game.data.config.Probabilities;
import ae.cyberspeed.game.data.config.StandardSymbol;
import ae.cyberspeed.game.exception.GameBoardException;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
public class GameBoardService {

    private GameConfig gameConfig;

    public GameBoardService(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public String[][] createGameBoard(GameConfig gameConfig) {
        if (gameConfig.getColumns() <= 0 || gameConfig.getRows() <= 0) {
            throw new GameBoardException("Columns and Rows must be greater than 0");
        }
        String[][] gameBoard = new String[gameConfig.getRows()][gameConfig.getColumns()];
        return gameBoard;
    }

    public double[][][] getStandardSymbolsProbabilityMatrix(GameConfig gameConfig) {
        Probabilities probabilities = gameConfig.getProbabilities();
        double[][][] matrices = new double[gameConfig.getRows()][gameConfig.getColumns()][6];
        for (int i = 0; i < gameConfig.getRows(); i++) {
            for (int j = 0; j < gameConfig.getColumns(); j++) {
                for (int k = 0; k < 6; k++) {
                    StandardSymbol standardSymbol = probabilities.getStandard_symbols().get(k);
                    double totalProbability = standardSymbol.getSymbolTotalProbability();
                    switch (k) {

                        case 0: {
                            double probability = standardSymbol.getSymbols().getA().getProbability();
                            double result = probability / totalProbability;
                            matrices[i][j][k] = result;
                        }
                        break;
                        case 1: {
                            int probability = standardSymbol.getSymbols().getB().getProbability();
                            double result = probability / totalProbability;
                            matrices[i][j][k] = result;
                        }
                        break;
                        case 2: {
                            int probability = standardSymbol.getSymbols().getC().getProbability();
                            double result = probability / totalProbability;
                            matrices[i][j][k] = result;
                        }
                        break;
                        case 3: {
                            int probability = standardSymbol.getSymbols().getD().getProbability();
                            double result = probability / totalProbability;
                            matrices[i][j][k] = result;
                        }
                        break;
                        case 4: {
                            int probability = standardSymbol.getSymbols().getE().getProbability();
                            double result = probability / totalProbability;
                            matrices[i][j][k] = result;
                        }
                        break;
                        case 5: {
                            int probability = standardSymbol.getSymbols().getF().getProbability();
                            double result = probability / totalProbability;
                            matrices[i][j][k] = result;
                        }
                        break;
                    }

                }
            }
        }
        return matrices;
    }

    public String[][][] getBonusSymbolProbabilityMatrix(GameConfig gameConfig) {
        String[] arrayBonusProbability = new String[4];
        Probabilities probabilities = gameConfig.getProbabilities();
        String _10x = probabilities.getBonus_symbols().getSymbols().get_10x().getName();
        arrayBonusProbability[0] = _10x;
        String _5x = probabilities.getBonus_symbols().getSymbols().get_5x().getName();
        arrayBonusProbability[1] = _5x;
        String _500x = probabilities.getBonus_symbols().getSymbols().get_500().getName();
        arrayBonusProbability[2] = _500x;
        String _1000x = probabilities.getBonus_symbols().getSymbols().get_1000().getName();
        arrayBonusProbability[3] = _1000x;
        String _MISS = probabilities.getBonus_symbols().getSymbols().getMISS().getName();

        String[][][] matrices = new String[gameConfig.getRows()][gameConfig.getColumns()][4];
        for (int i = 0; i < gameConfig.getRows(); i++) {
            for (int j = 0; j < gameConfig.getColumns(); j++) {
                for (int k = 0; k < 4; k++) {
                    Random random = new Random();
                    int item = random.nextInt(4);
                    matrices[i][j][k] = arrayBonusProbability[item];
                }
            }
        }
        return matrices;
    }
}
