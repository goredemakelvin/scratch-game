package ae.cyberspeed.game.data.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SameSymbolsVertically implements WinItem {
    private int reward_multiplier;
    private String when;
    private String group;
    private ArrayList<ArrayList<String>> covered_areas;
}
