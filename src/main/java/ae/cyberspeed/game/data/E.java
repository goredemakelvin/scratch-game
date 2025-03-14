package ae.cyberspeed.game.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class E{
    private double reward_multiplier;
    private String type;
    @JsonProperty("e")
    private int probability;

    public E(int probability) {
        this.probability = probability;
    }
}
