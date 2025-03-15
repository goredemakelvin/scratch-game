package ae.cyberspeed.game.data.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class _5x {
    private int reward_multiplier;
    private String type;
    private String impact;
    @JsonProperty("5x")
    private int probability;
    private String name = "10X";

    public _5x(int probability) {
        this.probability = probability;
    }
}
