package ae.cyberspeed.game;

import ae.cyberspeed.game.data.Root;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args ) throws IOException {

        ObjectMapper mapper=new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        InputStream is = App.class.getClassLoader().getResourceAsStream("config.json");
        Root testObj = mapper.readValue(is, Root.class);

    }
}
