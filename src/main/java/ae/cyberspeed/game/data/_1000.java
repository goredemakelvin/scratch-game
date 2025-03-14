package ae.cyberspeed.game.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

@JsonRootName(value = "+1000")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class _1000{
    private int extra;
    private String type;
    private String impact;
    @JsonProperty("+1000")
    private int probability;

    public _1000(int probability) {
        this.probability = probability;
    }
}
