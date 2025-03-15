package ae.cyberspeed.game.data.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonRootName(value = "+500")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class _500 {
    private int extra;
    private String type;
    private String impact;
    @JsonProperty("+500")
    private int probability;
    private String name = "+500";

    public _500(int probability) {
        this.probability = probability;
    }

}
