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
public class F{
    private int reward_multiplier;
    private String type;
    @JsonProperty("f")
    private int probability;

    public F(int probability) {
        this.probability = probability;
    }
}
