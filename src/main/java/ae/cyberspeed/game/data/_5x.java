package ae.cyberspeed.game.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class _5x{
    private int reward_multiplier;
    private String type;
    private String impact;
    @JsonProperty("5x")
    private int probability;

    public _5x(int probability) {
        this.probability = probability;
    }
}
