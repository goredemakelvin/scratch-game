package ae.cyberspeed.game;

import ae.cyberspeed.game.data.business.Bet;
import ae.cyberspeed.game.data.business.Result;
import ae.cyberspeed.game.data.config.GameConfig;
import ae.cyberspeed.game.data.config.WinItem;
import ae.cyberspeed.game.service.DisplayService;
import ae.cyberspeed.game.service.GameBoardService;
import ae.cyberspeed.game.service.WinningCombinationService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;



public class App {
    public static void main(String[] args) throws IOException {
       // init(args);
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        InputStream is = App.class.getClassLoader().getResourceAsStream("config.json");
        DisplayService displayService = new DisplayService();
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Bet Amount :");
        Double amount = 10.10;
        //scanner.nextDouble();
        displayService.printBetAmount(new Bet(amount));
        GameConfig gameConfig = mapper.readValue(is, GameConfig.class);
        GameBoardService gameBoardService = new GameBoardService(gameConfig);
        double[][][] boardMatrices = gameBoardService.getStandardSymbolsProbabilityMatrix(gameConfig);
        char[][] generatedSymbols = displayService.generateStandardSymbol(boardMatrices, gameConfig.getRows(), gameConfig.getColumns());
        WinningCombinationService winningCombinationService = new WinningCombinationService();
        List<WinItem> winItems = winningCombinationService.applyWinningCombinations(generatedSymbols, gameConfig);
        Result result=new Result();
        result.setMatrix(generatedSymbols);
        result.setAppliedWinningCombinations(winItems);
        result.setReward("500");
        result.setAppliedBonusSymbol("");
        mapper.writeValue(System.out, result);




    }

    public static Params init(String... args) throws IOException {
       if( args==null || args.length == 0) {
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
        System.out.println("Config Path: " + configPath);
        System.out.println("Betting Amount: " + bettingAmount);

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



