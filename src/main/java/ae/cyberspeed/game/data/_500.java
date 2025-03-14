package ae.cyberspeed.game.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

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

    public _500(int probability) {
        this.probability = probability;
    }

}
