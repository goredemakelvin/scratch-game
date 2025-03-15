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
public class B {
    private int reward_multiplier;
    private String type;
    @JsonProperty("b")
    private int probability;
    private char name = 'B';

    public B(int probability) {
        this.probability = probability;
    }

}
