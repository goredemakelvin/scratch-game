package ae.cyberspeed.game.data.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class A {
    private int rewardMultiplier;
    private String type;
    @JsonProperty("a")
    private int probability;
    private char name = 'A';

    public A(int probability) {
        this.probability = probability;
    }

}
