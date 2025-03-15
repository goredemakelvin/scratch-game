package ae.cyberspeed.game.data.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class _10x{
    private int reward_multiplier;
    private String type;
    private String impact;
    @JsonProperty("10x")
    private int probability;
    private String name = "10X";

    public _10x(int probability) {
        this.probability = probability;
    }
}
