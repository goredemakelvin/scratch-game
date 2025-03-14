package ae.cyberspeed.game.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class A{
    private int rewardMultiplier;
    private String type;
    @JsonProperty("a")
    private int probability;

    public A(int probability) {
        this.probability = probability;
    }

}
