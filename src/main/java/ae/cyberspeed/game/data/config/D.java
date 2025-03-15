package ae.cyberspeed.game.data.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class D{
    private int reward_multiplier;
    private String type;
    @JsonProperty("d")
    private int probability;
    private char name = 'D';

    public D(int probability) {
        this.probability = probability;
    }
}
