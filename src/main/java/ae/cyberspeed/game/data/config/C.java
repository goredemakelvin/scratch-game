package ae.cyberspeed.game.data.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class C {
    private double reward_multiplier;
    private String type;
    @JsonProperty("c")
    private int probability;
    private char name = 'C';


    public C(int probability) {
        this.probability = probability;
    }
}
