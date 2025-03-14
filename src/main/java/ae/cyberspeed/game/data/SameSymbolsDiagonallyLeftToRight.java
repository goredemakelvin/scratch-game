package ae.cyberspeed.game.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SameSymbolsDiagonallyLeftToRight{
    private int reward_multiplier;
    private String when;
    private String group;
    private ArrayList<ArrayList<String>> covered_areas;
}
