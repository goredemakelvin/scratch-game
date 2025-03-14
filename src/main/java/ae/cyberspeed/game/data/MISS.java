package ae.cyberspeed.game.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonRootName(value = "MISS")
public class MISS{
    private String type;
    private String impact;
    @JsonProperty("MISS")
    private int probability;
    public MISS(int probability) {
        this.probability = probability;
    }
}
