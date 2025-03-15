package ae.cyberspeed.game.data.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SameSymbol3Times implements WinItem {
    private int reward_multiplier;
    private String when;
    private int count;
    private String group;
}
