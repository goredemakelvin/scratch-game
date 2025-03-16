package ae.cyberspeed.game;

import ae.cyberspeed.game.data.business.Bet;
import ae.cyberspeed.game.data.business.Result;
import ae.cyberspeed.game.data.config.GameConfig;
import ae.cyberspeed.game.data.config.WinItem;
import ae.cyberspeed.game.service.DisplayService;
import ae.cyberspeed.game.service.GameBoardService;
import ae.cyberspeed.game.service.RewardService;
import ae.cyberspeed.game.service.WinningCombinationService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;


public class App {
    public static void main(String[] args) throws IOException {
        Params init = init(args);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        FileInputStream fis = new FileInputStream(init.getConfigPath());

        DisplayService displayService = new DisplayService();
        displayService.printBetAmount(new Bet(init.getBettingAmount()));
        GameConfig gameConfig = mapper.readValue(fis, GameConfig.class);
        GameBoardService gameBoardService = new GameBoardService(gameConfig);
        double[][][] standardSymbolProbabilities = gameBoardService.getStandardSymbolsProbabilityMatrix(gameConfig);
        String[][] generatedSymbols = displayService.generateStandardSymbol(standardSymbolProbabilities, gameConfig.getRows(), gameConfig.getColumns());
        WinningCombinationService winningCombinationService = new WinningCombinationService();
        Map<WinItem, String> winItems = winningCombinationService.applyWinningCombinations(generatedSymbols, gameConfig);
        String[][][] bonusSymbolProbabilityMatrix = gameBoardService.getBonusSymbolProbabilityMatrix(gameConfig);
        Random random = new Random();
        int randomRow = random.nextInt(gameConfig.getRows());
        int randomCol = random.nextInt(gameConfig.getColumns());
        int randomBonusSymbol = random.nextInt(4);
        // Get the random item
        String randomItem = bonusSymbolProbabilityMatrix[randomRow][randomCol][randomBonusSymbol];
        RewardService rewardService = new RewardService();
        double reward = rewardService.calculateReward(winItems, init.getBettingAmount(), randomItem, gameConfig);
        Result result = new Result();
        result.setMatrix(generatedSymbols);
        result.setAppliedWinningCombinations(winItems);
        result.setReward(reward);
        result.setAppliedBonusSymbol(randomItem);
        mapper.writeValue(System.out, result);


    }

    public static Params init(String... args)  {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No parameters given");
        }
        String configPath = null;
        double bettingAmount = 0;
        // Iterate over the command-line arguments
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--config":
                    if (i + 1 < args.length) {
                        configPath = args[i + 1];
                        i++;  // Skip next arg (already processed)
                    } else {
                        System.err.println("Error: Missing value for --config");
                        throw new IllegalArgumentException("Error: Missing value for --config");
                    }
                    break;
                case "--betting-amount":
                    if (i + 1 < args.length) {
                        try {
                            bettingAmount = Double.parseDouble(args[i + 1]);
                            i++;  // Skip next arg (already processed)
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid value for --betting-amount");
                        }
                    } else {
                        System.err.println("Error: Missing value for --betting-amount");
                        throw new IllegalArgumentException("Error: Missing value for --betting-amount");
                    }
                    break;
                default:
                    System.err.println("Unknown argument: " + args[i]);
                    throw new IllegalArgumentException("Unknown argument: " + args[i]);
            }
        }

        // Show processed values

        Params params = new Params();
        params.setConfigPath(configPath);
        params.setBettingAmount(bettingAmount);
        return params;

    }
}

@Data
class Params {
    String configPath;
    double bettingAmount;
}



