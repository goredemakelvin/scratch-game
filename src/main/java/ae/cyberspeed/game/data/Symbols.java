package ae.cyberspeed.game.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Symbols{
    @JsonProperty("A")
    private A a;
    @JsonProperty("B") 
    private B b;
    @JsonProperty("C") 
    private C c;
    @JsonProperty("D") 
    private D d;
    @JsonProperty("E") 
    private E e;
    @JsonProperty("F") 
    private F f;
    @JsonProperty("10x") 
    private _10x _10x;
    @JsonProperty("5x") 
    private _5x _5x;
    @JsonProperty("+1000")
    private _1000 _1000;
    @JsonProperty("+500")
    private _500 _500;
    @JsonProperty("MISS") 
    private MISS mISS;



}
