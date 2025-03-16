package ae.cyberspeed.game.service;

import ae.cyberspeed.game.data.config.GameConfig;
import ae.cyberspeed.game.data.config.Probabilities;
import ae.cyberspeed.game.data.config.StandardSymbol;
import ae.cyberspeed.game.data.config.Symbols;
import ae.cyberspeed.game.exception.GameBoardException;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
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
        StandardSymbol[] arr = new StandardSymbol[probabilities.getStandard_symbols().size()];
        arr = probabilities.getStandard_symbols().toArray(arr);
        double[][][] matrice = new double[gameConfig.getRows()][gameConfig.getColumns()][6];
                Map<Integer,double[]> items = new HashMap<>();
                for (int k = 0; k < arr.length; k++) {
                    double[] m = new double[6];
                    double symbolTotalProbability = arr[k].getSymbolTotalProbability();
                    Symbols symbols = arr[k].getSymbols();
                    double a = symbols.getA().getProbability();
                    double b = symbols.getB().getProbability();
                    double c = symbols.getC().getProbability();
                    double d = symbols.getD().getProbability();
                    double e = symbols.getE().getProbability();
                    double f = symbols.getF().getProbability();
                    m[0] = (a / symbolTotalProbability);
                    m[1] = (b / symbolTotalProbability);
                    m[2] = (c / symbolTotalProbability);
                    m[3] = (d / symbolTotalProbability);
                    m[4] = (e / symbolTotalProbability);
                    m[5] = (f / symbolTotalProbability);
                    items.put(k,m);
            }
          for(int i=0;i<gameConfig.getRows();i++){
              for(int j=0;j<gameConfig.getColumns();j++){
                Random rand = new Random();
                  int p = rand.nextInt(8);
                  matrice[i][j] = items.get(p);
              }
          }
        return matrice;
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
    public String getLossSymbol(GameConfig gameConfig){
        return  gameConfig.getProbabilities().getBonus_symbols().getSymbols().getMISS().getName();
    }
}
